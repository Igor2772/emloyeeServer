package telran.employees.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

public class EmployeesMap implements IEmployees
{
	HashMap<Integer, Employee> employees = new HashMap<>();
	HashMap<String, List<Employee>> companies = new HashMap<>();
	TreeMap<Integer, List<Employee>> salaries = new TreeMap<>();
	
	@Override
	public boolean hireEmployee(Employee emp)
	{
		boolean res = employees.putIfAbsent(emp.getId(), emp) == null;
		if (res)
		{
			addCompanies(emp);
			addSalaries(emp);
		}
		return res;
	}
	
	private void addSalaries(Employee empl)
	{
		int salary = empl.getSalary();
		List<Employee> emplList = salaries.getOrDefault(salary, new ArrayList<>());
		emplList.add(empl);
		salaries.putIfAbsent(salary, emplList);
	}

	private void addCompanies(Employee empl)
	{
		String companyName = empl.getCompany();
		List<Employee> emplList = companies.getOrDefault(companyName, new ArrayList<>());
		emplList.add(empl);
		companies.putIfAbsent(companyName, emplList);
	}

	@Override
	public boolean fireEmployee(int id)
	{
		Employee empl = employees.remove(id);
		if (empl != null)
		{
			removeCompanies(empl);
			removeSalaries(empl);
		}
		return empl != null;
	}
	
	private void removeSalaries(Employee empl)
	{
		int salary = empl.getSalary();
		List<Employee> emplList = salaries.get(salary);
		emplList.remove(empl);
		if (emplList.isEmpty()) // no need to keep empty list in the map
			salaries.remove(salary);
	}

	private void removeCompanies(Employee empl)
	{
		String companyName = empl.getCompany();
		List<Employee> emplList = companies.get(companyName);
		emplList.remove(empl);
		if (emplList.isEmpty()) // no need to keep empty list in the map
			companies.remove(companyName);
	}

	@Override
	public Employee getEmployeeData(int id)
	{
		return employees.get(id);
	}

	@Override
	public List<Employee> getEmployeesData(int salaryFrom, int salaryTo)
	{
		return salaries.subMap(salaryFrom, salaryTo).values().stream().flatMap(List::stream)
		        .collect(Collectors.toList());
	}

	@Override
	public int getAvgSalary()
	{
		double avgSalary = employees.values().stream()
				.collect(Collectors.averagingInt(e -> e.getSalary()));
		return (int) avgSalary;
	}

	@Override
	public List<CompanySalary> getCompaniesAvgSalary()
	{
		return companies.entrySet().stream().map(e ->
		{
			double avgSalary = e.getValue().stream().collect(Collectors.
					averagingInt(empl -> empl.getSalary()));
			return new CompanySalary(e.getKey(), avgSalary);
		}).collect(Collectors.toList());
	}

	@Override
	public List<CompanySalary> getCompaniesGreaterAvgSalary()
	{
		int avgSalary = getAvgSalary();
		List<CompanySalary> companySalaries = getCompaniesAvgSalary();
		return companySalaries.stream().filter(c -> c.getAvgSalary() > avgSalary)
				.collect(Collectors.toList());
	}

}
