package com.spring.jdbc.dao;
import com.spring.jdbc.entity.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;  

@Component("studentdao")
public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		//insert Data
		String query="insert into student(id,name,city) values(?,?,?)";
		
		int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		
		return r;
	}
	
	public int change(Student student) {
		//update data
		
		String query="update student set name=?, city=? where id=?";
		
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		
		
		return r;
	}
	public int delete(Student student) {
		//Delete data
		
		String query="delete from student where id=?";
		
		int r=this.jdbcTemplate.update(query,student.getId());
		
		return r;
	
	}

	


	public Student getStudent(int studentid) {
		//select single student data
		
		String query="select * from student where id=?";
		
		
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper,studentid);
		
		return student;
	}

	
	
	public List<Student> getAllStudents() {
		//selecting multiple students(data)
		String query="Select * from student";
	
		List<Student> students=this.jdbcTemplate.query(query, new RowMapperImpl());
		
		return students;
	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	



	

}
 