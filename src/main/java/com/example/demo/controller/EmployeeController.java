package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "employee/create", method = RequestMethod.POST, produces = "application/json")
	public String createEmployee(@RequestBody Employee employee) {
		return employeeService.createNewEmployee(employee);

	}

	@RequestMapping(value = "employee/fetchAll", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> fetchAllEmployee() {
		return employeeService.getAllEmployees();

	}

	@RequestMapping(value = "employee/fetchBy/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Employee> fetchEmployee(@PathVariable int id) {
		return employeeService.getExistingEmployee(id);

	}

	@RequestMapping(value = "employee/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteExistingEmployee(id);

	}

}
