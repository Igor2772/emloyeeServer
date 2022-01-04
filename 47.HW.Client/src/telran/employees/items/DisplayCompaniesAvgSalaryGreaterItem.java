package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class DisplayCompaniesAvgSalaryGreaterItem extends EmployeesItem
{
	public DisplayCompaniesAvgSalaryGreaterItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Display companies with average salary greater than total average value";
	}

	@Override
	public void perform()
	{
		employees.getCompaniesGreaterAvgSalary().forEach(inputOutput::outputLine);
	}
}
