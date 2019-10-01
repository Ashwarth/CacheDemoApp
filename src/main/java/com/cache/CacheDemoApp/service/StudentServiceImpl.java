package com.cache.CacheDemoApp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cache.CacheDemoApp.beans.Student;

@Service
public class StudentServiceImpl implements studentService {

	@Cacheable(value = "studentCache", key = "'studentCache'+#studentId")
	@Override
	public Optional<Student> getStudentById(Integer studentId) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<Student> studentsList = Arrays.asList(
				new Student(1,"anr"),
				new Student(2, "Ashwarth"),
				new Student(2 , "Sai")
				);
		
		return studentsList.stream().filter(std -> std.getId().equals(studentId)).findFirst();
	}

}
