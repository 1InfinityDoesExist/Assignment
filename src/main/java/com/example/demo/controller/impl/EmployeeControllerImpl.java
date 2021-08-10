package com.example.demo.controller.impl;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.EmployeeController;
import com.example.demo.entity.Employee;
import com.example.demo.entity.request.EmployeeCreateRequest;
import com.example.demo.entity.request.EmployeeUpdateRequest;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RestController
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "employee/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ModelMap> createEmployee(@RequestBody EmployeeCreateRequest employee) {
		Employee empl = employeeService.createNewEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ModelMap().addAttribute("id", empl.getId()));

	}

	@RequestMapping(value = "employee/fetchAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee>> fetchAllEmployee(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees(pageable));

	}

	@RequestMapping(value = "employee/fetchBy/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Employee> fetchEmployee(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getExistingEmployee(id));

	}

	@RequestMapping(value = "employee/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
		employeeService.deleteExistingEmployee(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(@Valid EmployeeUpdateRequest request, String id)
			throws JsonProcessingException, ParseException {

		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(request, id));
	}

	@GetMapping("/searchMultiField/{firstname}/{age}")
	public ResponseEntity<List<Employee>> serachByMultiField(@PathVariable String name, Pageable pageable)
			throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.searchMultiField(name, pageable));
	}

}
