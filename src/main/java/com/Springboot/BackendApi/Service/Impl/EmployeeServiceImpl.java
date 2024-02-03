package com.Springboot.BackendApi.Service.Impl;

import com.Springboot.BackendApi.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.Sprinboot.BackendApi.Service.EmployeeService;
import com.Springboot.BackendApi.Model.Employee;
import com.Springboot.BackendApi.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return  employee.get();
		} else
		{
			throw  new ResourceNotFoundException("Employee","Id", id);
		}
	}

	public Employee updateEmployee(Employee employee, long id) {
		Employee updateemployee = employeeRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Employee","Id",id));

		updateemployee.setFirstName(employee.getFirstName());
		updateemployee.setLastName(employee.getLastName());
		updateemployee.setEmail(employee.getEmail());

		employeeRepository.save(updateemployee);
		return updateemployee;

	}

	@Override
	public void deleteEmployee(long id) {

		// check data is available or not in db
		employeeRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Employee","Id",id));

		employeeRepository.deleteById(id);

	}


}
