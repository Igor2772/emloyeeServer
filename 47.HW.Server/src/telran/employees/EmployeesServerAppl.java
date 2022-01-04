package telran.employees;

import java.io.IOException;

import telran.employees.net.EmployeesTcpProtocol;
import telran.employees.service.EmployeesMap;
import telran.employees.service.IEmployees;
import telran.net.server.ProtocolJava;
import telran.net.server.ServerJava;

public class EmployeesServerAppl
{
	private static final int PORT = 2000;

	public static void main(String[] args) throws IOException
	{
		IEmployees employees = new EmployeesMap();
		ProtocolJava protocol = new EmployeesTcpProtocol(employees);
		ServerJava serverJava = new ServerJava(protocol , PORT);
		serverJava.run();
	}

}
