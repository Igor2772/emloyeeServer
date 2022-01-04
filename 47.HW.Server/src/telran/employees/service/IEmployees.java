package telran.employees.service;

import java.util.List;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

public interface IEmployees
{
	boolean hireEmployee(Employee emp);
	boolean fireEmployee(int id);
	Employee getEmployeeData(int id);
	List<Employee> getEmployeesData(int salaryFrom, int salaryTo);
	int getAvgSalary();
	List<CompanySalary> getCompaniesAvgSalary();
	List<CompanySalary> getCompaniesGreaterAvgSalary();
}
