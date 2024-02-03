package com.Sprinboot.BackendApi.Service;

import com.Springboot.BackendApi.Model.Employee;

import java.util.List;

public interface  EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(long id);

	Employee updateEmployee(Employee employee,long id);

	void deleteEmployee(long id);
}
