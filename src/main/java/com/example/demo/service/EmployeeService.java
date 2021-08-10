package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public String getAllEmployees() {

		Map<String, Object> m = new HashMap<>();
		m.put("message", "Hello");

		return null;
	}

	public Map<String, Object> createNewEmployee() {

		Map<String, Object> m = new HashMap<>();
		m.put("message", "Hello");

		return m;
	}

	public Map<String, Object> updateExistingEmployee() {

		Map<String, Object> m = new HashMap<>();
		m.put("message", "Hello");

		return m;
	}

	public Map<String, Object> deleteExistingEmployee() {

		Map<String, Object> m = new HashMap<>();
		m.put("message", "Hello");

		return m;
	}

}
