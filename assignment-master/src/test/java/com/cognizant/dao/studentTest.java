package com.cognizant.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.config.SpringJava;
import com.cognizant.model.Student;

public class studentTest {
	
	private StudentDaoImpl simpl;
	private Student student;
	private AnnotationConfigApplicationContext apx;
	
	@Before
	public void setup() {
		apx = new AnnotationConfigApplicationContext(SpringJava.class);
		simpl = (StudentDaoImpl) apx.getBean("studentDao");
		student = new Student(987, "Sample", 92);
	}
	
	@Test
	public void testInsertOrNot() {
		assertEquals(1, simpl.insert(student));
	}
	
	@Test
	public void testViewAll() {
		List<Student> students = simpl.getAll();
		assertEquals(student, students.get(students.size() - 1));
	}
	
	@After
	public void teardown() {
		apx.close();
	}
	
}
