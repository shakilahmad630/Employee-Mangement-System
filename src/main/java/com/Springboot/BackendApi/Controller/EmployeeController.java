
package com.Springboot.BackendApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Sprinboot.BackendApi.Service.EmployeeService;
import com.Springboot.BackendApi.Model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// create Rest ApI for save Data

	@RequestMapping(value="/create",method = RequestMethod.POST)
	public ResponseEntity<Employee> saveEmployee(@RequestBody  Employee employee) throws JsonProcessingException
	{
		System.out.println(new ObjectMapper().writeValueAsString(employee));
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

	}
// get all employee REST API
	@RequestMapping(value="/get" ,method=RequestMethod.GET)
	public List<Employee> getAllEmployee()
	{
        return employeeService.getAllEmployee();
	}

	// get id of employee Rest API

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
	{
           return  new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK );
	      }

          // update employee Rest API
    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee)
    {
        return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }

	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		employeeService.deleteEmployee(id);
		return  new ResponseEntity<String>("Employee deleted Successfully !",HttpStatus.OK);
	}

}
