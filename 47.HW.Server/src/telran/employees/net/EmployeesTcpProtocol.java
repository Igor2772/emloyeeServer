package telran.employees.net;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TcpResponseCode;
import telran.net.server.ProtocolJava;

public class EmployeesTcpProtocol implements ProtocolJava
{
	IEmployees employees;
	String[] methods = { "hireEmployee", "fireEmployee", "getEmployeeData", "getEmployeesData", "getAvgSalary",
			"getCompaniesAvgSalary", "getCompaniesGreaterAvgSalary" };

	public EmployeesTcpProtocol(IEmployees empoyees)
	{
		super();
		this.employees = empoyees;
	}

	@Override
	public ResponseJava getResponse(RequestJava request)
	{
		Serializable requestData = request.requestData;
		EmployeesTcpProtocol etp = new EmployeesTcpProtocol(employees);
		
		String res = check(requestData);
			try
			{
				Method m = EmployeesTcpProtocol.class.getDeclaredMethod(res, String.class);
				m.setAccessible(true);
				return (ResponseJava) m.invoke(new EmployeesTcpProtocol(employees), requestData);
			} catch (Exception e)
			{
				return wrongResponse(e.getMessage());	
			}
//			return new ResponseJava(TcpResponseCode.UNKNOWN, null);
		}
//		switch(request.requestType)
//		{
//		case "hireEmployee" :
//			return hireEmployee(requestData);
//		case "fireEmployee" :
//			return fireEmployee(requestData);
//		case "getEmployeeData" :
//			return getEmployeeData(requestData);
//		case "getEmployeesData" :
//			return getEmployeesData(requestData);
//		case "getAvgSalary" :
//			return getAvgSalary(requestData);
//		case "getCompaniesAvgSalary" :
//			return getCompaniesAvgSalary(requestData);
//		case "getCompaniesGreaterAvgSalary" :
//			return getCompaniesGreaterAvgSalary(requestData);
//		default	:
//			return new ResponseJava(TcpResponseCode.UNKNOWN, null);
//		}
//}

	private String check(Serializable requestData)
	{
		for (String str : methods)
		{
			if (str.equals(requestData))
				return str;
		}
		return null;
	}

	private ResponseJava getCompaniesGreaterAvgSalary(Serializable requestData)
	{
		try
		{
			List<CompanySalary> res = employees.getCompaniesGreaterAvgSalary();
			return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
		} catch (Exception e)
		{
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava getCompaniesAvgSalary(Serializable requestData)
	{
		try
		{
			List<CompanySalary> res = employees.getCompaniesAvgSalary();
			return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
		} catch (Exception e)
		{
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava getAvgSalary(Serializable requestData)
	{
		try
		{
			Integer res = employees.getAvgSalary();
			return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
		} catch (Exception e)
		{
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava getEmployeesData(Serializable requestData)
	{
		try
		{
			Integer[] salaryRange = (Integer[]) requestData;
			List<Employee> res = employees.getEmployeesData(salaryRange[0], salaryRange[1]);
			return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
		} catch (Exception e)
		{
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava getEmployeeData(Serializable requestData)
	{
		try
		{
			Integer id = (Integer) requestData;
			Employee res = employees.getEmployeeData(id);
			return new ResponseJava(TcpResponseCode.OK, (Serializable) res);
		} catch (Exception e)
		{
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava fireEmployee(Serializable requestData)
	{
		try
		{
			Integer id = (Integer) requestData;
			boolean res = employees.fireEmployee(id);
			return new ResponseJava(TcpResponseCode.OK, res);
		} catch (Exception e)
		{
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava hireEmployee(Serializable requestData)
	{
		try
		{
			Employee emp = (Employee) requestData;
			boolean res = employees.hireEmployee(emp);
			return new ResponseJava(TcpResponseCode.OK, res);
		} catch (Exception e)
		{
			return wrongResponse(e.getMessage());
		}
	}

	private ResponseJava wrongResponse(String message)
	{
		return new ResponseJava(TcpResponseCode.WRONG_REQUEST, message);
	}

}
