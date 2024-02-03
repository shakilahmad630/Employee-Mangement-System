package com.Springboot.BackendApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springboot.BackendApi.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
