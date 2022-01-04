package telran.employees;

import java.io.IOException;
import java.net.UnknownHostException;

import telran.employees.items.*;
import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import telran.view.*;

public class EmployeesClientAppl
{

	private static final String HOST = "localhost";
	private static final int PORT = 2000;
	

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		InputOutput inputOutput = new ConsoleInputOutput();
		IEmployees employees = new EmployeesTcpProxy(HOST, PORT);
		
		Item[] items = 
				{
						new HireEmployeeItem(inputOutput, employees),
						new FireEmployeeItem(inputOutput, employees),
						new DisplayEmployeeItem(inputOutput, employees),
						new DisplayEmployeesSalaryItem(inputOutput, employees),
						new DisplayAvgSalaryItem(inputOutput, employees),
						new DisplayCompaniesAvgSalaryGreaterItem(inputOutput, employees),
						new DisplayCompaniesSalariesItem(inputOutput, employees),
						new CloseConnectionAndExitItem(inputOutput, employees),
						new ExitItem()
				};
		
		Menu menu = new Menu(items, inputOutput);
		menu.runMenu();
	}

}
