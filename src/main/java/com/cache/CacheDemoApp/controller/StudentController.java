package com.cache.CacheDemoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cache.CacheDemoApp.beans.Student;
import com.cache.CacheDemoApp.service.studentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	private studentService studentService;
	
	@GetMapping("/id")
	public ResponseEntity<Student> getStudent(@RequestParam Integer studentId){
		
		return new ResponseEntity<Student>(studentService.getStudentById(studentId).get(), HttpStatus.OK);
	}
	


}
