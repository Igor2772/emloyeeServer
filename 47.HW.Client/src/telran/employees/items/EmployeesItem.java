package telran.employees.items;

import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class EmployeesItem implements Item
{
	protected InputOutput inputOutput;
	protected IEmployees employees;
	
	protected static final int MIN_SALARY = 6000;
	protected static final int MAX_SALARY = 60000;
		
	public EmployeesItem(InputOutput inputOutput, IEmployees employees)
	{
		super();
		this.inputOutput = inputOutput;
		this.employees = employees;
	}
	
	public Integer getNonExistingId()
	{
		Integer id = inputOutput.inputInteger("Enter id");
		if(id == null)
			return null;
		Employee emp = employees.getEmployeeData(id);
		if(emp != null)
		{
			inputOutput.outputLine("Employee already exists");
			return null;
		}
		return id;
	}

	protected Integer getExistingId()
	{
		Integer id = inputOutput.inputInteger("Enter identifier");
		if (id == null)
			return null;
		Employee empl = employees.getEmployeeData(id);
		if (empl == null)
		{
			inputOutput.outputLine("Employee with the entered ID not found");
			return null;
		}
		return id;
	}
}
