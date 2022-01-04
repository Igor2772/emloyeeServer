package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class DisplayCompaniesSalariesItem extends EmployeesItem
{
	public DisplayCompaniesSalariesItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Display companies and their average salaries";
	}

	@Override
	public void perform()
	{
		employees.getCompaniesAvgSalary().forEach(inputOutput::outputLine);
	}
}
