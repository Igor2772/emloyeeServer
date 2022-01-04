package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class DisplayAvgSalaryItem extends EmployeesItem
{
	public DisplayAvgSalaryItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Display average salary value";
	}

	@Override
	public void perform()
	{
		inputOutput.outputLine(employees.getAvgSalary());
	}
}
