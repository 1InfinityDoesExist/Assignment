package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.parser.ParseException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.request.EmployeeCreateRequest;
import com.example.demo.entity.request.EmployeeUpdateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RestController
public interface EmployeeController {

	public ResponseEntity<ModelMap> createEmployee(@Valid @RequestBody EmployeeCreateRequest employee);

	public ResponseEntity<List<Employee>> fetchAllEmployee(Pageable pageable);

	public ResponseEntity<Employee> fetchEmployee(@PathVariable String id);

	public ResponseEntity<Void> deleteEmployee(@PathVariable String id);

	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody EmployeeUpdateRequest request,
			@PathVariable String id) throws JsonProcessingException, ParseException;

	@GetMapping("/searchMultiField/{name}")
	public ResponseEntity<List<Employee>> serachByMultiField(@PathVariable String name, Pageable pageable)
			throws IOException;
}
