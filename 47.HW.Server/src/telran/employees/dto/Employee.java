package telran.employees.dto;

import java.io.Serializable;

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
		// can be simplified to:
		/*
		i suggest changing this code:	

		Employee other = (Employee) obj;
		if (company == null)
		{
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;

		to:
	
		if (!Objects.equals(this.getCompany(), other.getCompany())){
			return false;
		} 

		1)casting is removed, because the previous if statement checks getClass of the object -> casting is rudementary
		2)Objects.equals can compare two values with possible nulls -> simplifies if statement 
		3) I generally recomment to use this.getSomething() -> improves readability
		*/
		Employee other = (Employee) obj;
		if (company == null)
		{
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (id != other.id)
			return false;
		// check the comment above. the same applies here
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
