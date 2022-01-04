package telran.employees.service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;
import telran.net.TcpClientJava;

public class EmployeesTcpProxy extends TcpClientJava implements IEmployees
{

	public EmployeesTcpProxy(String hostname, int port) throws UnknownHostException, IOException
	{
		super(hostname, port);
	}

	@Override
	public boolean hireEmployee(Employee emp) 
	{
		// should the request be validated here?
		// what if the request returns incorrect data? TCP/UDP connection issue?
		// the same applies to other methods 
		return sendRequest("hireEmployee", emp);
	}

	@Override
	public boolean fireEmployee(int id)
	{
		return sendRequest("fireEmployee", id);
	}

	@Override
	public Employee getEmployeeData(int id)
	{
		return sendRequest("getEmployeeData", id);
	}

	@Override
	public List<Employee> getEmployeesData(int salaryFrom, int salaryTo) 
	{
		Integer[] data = {salaryFrom, salaryTo};
		return sendRequest("getEmployeesData", data);
	}

	@Override
	public int getAvgSalary()
	{
		return sendRequest("getAvgSalary", null);
	}

	@Override
	public List<CompanySalary> getCompaniesAvgSalary()
	{
		return sendRequest("getCompaniesAvgSalary", null);
	}

	@Override
	public List<CompanySalary> getCompaniesGreaterAvgSalary()
	{
		return sendRequest("getCompaniesGreaterAvgSalary", null);
	}
}
