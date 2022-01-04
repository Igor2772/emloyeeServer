package telran.employees.items;

import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class HireEmployeeItem extends EmployeesItem
{

	public HireEmployeeItem(InputOutput inputOutput, IEmployees employees)
	{
		super(inputOutput, employees);
	}

	@Override
	public String displayName()
	{
		return "Hire new employee";
	}

	@Override
	public void perform()
	{
		Integer id = getNonExistingId();
		if(id == null)
			return;
		
		String name = inputOutput.inputString("Enter name");
		if(name == null)
			return;
		
		String company = inputOutput.inputString("Enter company");
		if(company == null)
			return;
		
		Integer salary = inputOutput.inputInteger(String.format("Enter salary [%d-%d]", MIN_SALARY, 
				MAX_SALARY), MIN_SALARY, MAX_SALARY);
		if(salary == null)
			return;
		
		inputOutput.outputLine(employees.hireEmployee(new Employee(id, name, company, salary)));
	}
}
