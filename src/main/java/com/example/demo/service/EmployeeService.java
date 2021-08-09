package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public Map<String, Object> getAllEmployees() {

		Map<String, Object> m = new HashMap<>();
		m.put("message", "Hello");

		return m;
	}

}
