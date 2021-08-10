package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public String createNewEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee Added Successfully with id:- " + employee.getId();
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getExistingEmployee(int id) {
		return employeeRepository.findById(id);
	}

	public String deleteExistingEmployee(int id) {
		employeeRepository.deleteById(id);
		return "Employee Deleted Successfully with id:- " + id;
	}

}
