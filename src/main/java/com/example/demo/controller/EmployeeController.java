package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Controller
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value = "employee/create", method = RequestMethod.POST, produces = "application/json")
	public String createEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee Added Successfully with id:- ";

	}

	@RequestMapping(value = "employee/fetchAll", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> fetchAllEmployee() {
		return employeeRepository.findAll();

	}

	@RequestMapping(value = "employee/fetchBy/{id}", method = RequestMethod.GET, produces = "application/json")
	public String fetchEmployee(@PathVariable int id) {
		employeeRepository.findById(id);
		return "Employee Updated Successfully with id:- " + id;

	}

	@RequestMapping(value = "employee/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
		return "Employee Deleted Successfully with id:- " + id;

	}

}
