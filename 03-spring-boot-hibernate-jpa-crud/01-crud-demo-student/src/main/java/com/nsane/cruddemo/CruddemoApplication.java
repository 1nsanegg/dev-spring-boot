package com.nsane.cruddemo;

import com.nsane.cruddemo.dao.StudentDAO;
import com.nsane.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			/*createStudent(studentDAO);*/
			createMultipleStudent(studentDAO);
			/*readStudent(studentDAO);*/
			/*queryForStudent(studentDAO);*/
			/*queryForStudentByLastName(studentDAO);*/
			/*updateStudent(studentDAO);*/
			/*deleteStudent(studentDAO);*/
			/*deleteAllStudent(studentDAO);*/

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with idd: " + studentId);
		Student mysStudent = studentDAO.findById(studentId);
		// change first name to "Scooby"
		System.out.println("Updating student...");
		mysStudent.setFirstName("John");

		// update the student
		studentDAO.update(mysStudent);
		// display te updated student
		System.out.println("Update student: " + mysStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Jim ");
		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(theStudents);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of student
		for (Student tempStudent: theStudents
			 ) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Tuan", "Nguyen", " tuan@gmail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the student
		int theId = tempStudent.getId();
		System.out.println("The id of the student is " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieve student with the id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student" + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating new student object...");
		Student tempStudent1 = new Student("John", "Doe", "qw@1nsane.com");
		Student tempStudent2 = new Student("Joey", "Monica", "pweaul@1nsane.com");
		Student tempStudent3 = new Student("Mike", "Jim", "paewqul@1nsane.com");

		// save the objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@1nsane.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Save student. Generated id: " + tempStudent.getId());
	}
}
