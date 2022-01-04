package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;
import java.io.Closeable;
import java.io.IOException;

public class CloseConnectionAndExitItem extends EmployeesItem
{

	public CloseConnectionAndExitItem(InputOutput inputOutput, IEmployees employees) {
		super(inputOutput, employees);
	}

	@Override
	public String displayName() 
	{
		return "Close connection and exit";
	}

	@Override
	public void perform() 
	{
		try 
		{
			((Closeable)employees).close();
		} 
		catch (IOException e) 
		{
			inputOutput.outputLine(e.getMessage());;
		}
	}

	@Override
	public boolean isExit()
	{
		return true;
	}
}
