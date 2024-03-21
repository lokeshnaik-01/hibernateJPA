package com.lokesh.crudDemo;

import com.lokesh.crudDemo.dao.StudentDAO;
import com.lokesh.crudDemo.dao.StudentDAOImpl;
import com.lokesh.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.text.Style;
import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		System.out.println("Inside cmd liner runner");
		return runner -> {
			// createStudentAndRead(studentDAO);
			// createMultipleStudents(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on id
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);

		// change first name
		System.out.println("Update student");
		// we use the setter method
		myStudent.setFirstName("Qwerty");
		// update student
        studentDAO.update(myStudent);
		// display updated student
		System.out.println("Updates student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Naik");
		// display list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating new student object");
		Student tempStudent1 = new Student("Lokesh1", "Naik", "lokesh@gmail.com");
		Student tempStudent2 = new Student("Lokesh2", "Naik", "lokesh@gmail.com");
		Student tempStudent3 = new Student("Lokesh3", "Naik", "lokesh@gmail.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display id of saved student
		System.out.println("Saved student id: " + tempStudent1.getId());
		System.out.println("Saved student id: " + tempStudent2.getId());
		System.out.println("Saved student id: " + tempStudent3.getId());
	}

	private void createStudentAndRead(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Lavadiya", "Naik", "lokesh@gmail.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student id: " + theId);

		// retrieve student based on id: primary key
		System.out.println("Retrieve student with given id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found student: " + myStudent);

	}
}
