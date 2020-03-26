package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentDao {
	public List<Student> getAll();

	public int insert(Student student);
}
