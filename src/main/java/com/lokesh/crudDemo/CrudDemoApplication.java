package com.lokesh.crudDemo;

import com.lokesh.crudDemo.dao.StudentDAO;
import com.lokesh.crudDemo.dao.StudentDAOImpl;
import com.lokesh.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		System.out.println("Inside cmd liner runner");
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Lokesh", "Naik", "lokesh@gmail.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of saved student
		System.out.println("Saved student id: " + tempStudent.getId());
	}
}
