package com.cache.CacheDemoApp.service;

import java.util.Optional;

import com.cache.CacheDemoApp.beans.Student;

public interface studentService {

	public  Optional<Student> getStudentById(Integer studentId);
}
