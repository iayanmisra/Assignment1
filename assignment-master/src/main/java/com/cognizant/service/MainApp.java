package com.cognizant.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.config.SpringJava;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext apx = new AnnotationConfigApplicationContext(SpringJava.class);
		StudentDaoImpl simpl = (StudentDaoImpl) apx.getBean("studentDao");
//		Student st = new Student(1, "Avik", 1000);
//		Student st2 = new Student(2, "Avi2", 2000);
//		Student st3 = new Student(3, "Avi3", 3000);
//		simpl.insert(st);
//		simpl.insert(st2);
//		simpl.insert(st3);
		List<Student> student = simpl.getAll();
		System.out.println("ID\t\tNAME\t\tMARKS\n------------------------------------");
		for (Student e : student) {
			System.out.println(e);
		}
//		apx.close();
	}
}
