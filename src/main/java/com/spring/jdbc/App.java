package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.spring.jdbc.entity.Student;

import com.spring.jdbc.dao.StudentDao;

/**  
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// spirng jdbc=> jdbc Tempplate

		//ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
	
		
		StudentDao studentDao=context.getBean("studentdao",StudentDao.class);
		
		Student student=new Student();
		 
		student.setId(54);
		student.setName("Musabbir");
		student.setCity("Katihaar");
		
		int result =studentDao.insert(student);
		
//		System.out.println("Student Added: "+result);
//		
		//Update Data:
//		Student student=new Student();
//		student.setId(2);
//		student.setName("Raj Kumar Rao");
//		student.setCity("Lucknow");
//		 
//		int result=studentDao.change(student);
//		System.out.println("Data changed Successfully.. "+result);
		
		//DELETE data
//		Student student=new Student();
//		student.setId(23);
//		int result=studentDao.delete(student);
//		System.out.println("Data Deleted Successfullyy..."+ result);
		
		//SELECT SINGLE DATA
//		Student student=studentDao.getStudent(2);
//		System.out.println(student);
//		
		
		//SELECT MULTIPLE ROWS
		List<Student> students=studentDao.getAllStudents();
		
		for(Student s:students)
		{
			System.out.println(s);
		}
		
	}
}
