package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.model.Student;

@Component
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> getAll() {
		StudentDaoRowMapper rowMapper = new StudentDaoRowMapper();
		String sql = "select * from Student";
		List<Student> listofStudent = jdbcTemplate.query(sql, rowMapper);
		return listofStudent;
	}

	@Override
	public int insert(Student student) {
		String sqlInsert = "insert into Student values(?,?,?)";
		int result = jdbcTemplate.update(sqlInsert, student.getId(), student.getName(), student.getMarks());
		return result;
	}
}
