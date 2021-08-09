package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmployeeService;

@Controller
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "employee/fetchAll", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> demoFetch() {
		return employeeService.getAllEmployees();

	}

}
