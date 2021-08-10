package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Employee")
public class Employee {

	@Id
	private int id;
	private String name;
	private int salary;
	private String gender;
	private String team;
	private EmployeeAddress address;

}
