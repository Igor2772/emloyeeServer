package telran.employees.dto;

import java.io.Serializable;

// perhaps it's a good idea to separate model class lik Employee and Company salary as java library?
// this way you can avoid code duplication and not be afraid to cause incosistency inside your application
// https://docs.oracle.com/middleware/1213/wls/WLPRG/libraries.htm#WLPRG333
@SuppressWarnings("serial")
public class Employee implements Serializable
{
	private int id;
	private String name;
	private String company;
	private int salary;
	
	public Employee(int id, String name, String company, int salary)
	{
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.salary = salary;
	}
	
	public Employee()
	{
		// TODO Auto-generated constructor stub
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (company == null)
		{
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (id != other.id)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Employee [id=" + id + ", name=" + name + ", company=" + company + ", salary=" + salary + "]";
	}
	
	
}
