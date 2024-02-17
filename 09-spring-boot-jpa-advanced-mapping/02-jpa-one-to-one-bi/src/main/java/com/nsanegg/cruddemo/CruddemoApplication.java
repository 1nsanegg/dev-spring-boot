package com.nsanegg.cruddemo;

import com.nsanegg.cruddemo.dao.AppDao;
import com.nsanegg.cruddemo.entity.Instructor;
import com.nsanegg.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			/*createInstructor(appDao);*/

			/*findInstructor(appDao);*/

			/*deleteInstructor(appDao);*/
			/*findInstructorDetail(appDao);
*/
			deleteInstructorDetail(appDao);
		};
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int theId = 3;
		System.out.println("Deleting instructorDetail id: " + theId);
		appDao.deleteInstructorDetailById(theId);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDao appDao) {
		// get the instructor detail object
		int theId = 2;
		InstructorDetail instructorDetail = appDao.findInstructorDetailById(theId);
		// print the instructor detail
		System.out.println("tempInstructorDetail: " + instructorDetail);
		// print the associated instructor
		System.out.println("the associated Instructor: " + instructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDao appDao) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDao.deleteInstructorById(theId);
		System.out.println("Done!!");
	}

	private void findInstructor(AppDao appDao) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println(" the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {

		/*// create the instructor
		Instructor tempInstructor = new Instructor("Tuan", "Nguyen", "tuan12@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.1nsane.com/youtube", "playgame");*/

		// create the instructor
		Instructor tempInstructor = new Instructor("Ky", "Dang", "ky12@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.1nsane.com/youtube", "music");

		// associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NoteL this will also save the details object
		// because of cascadetype.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("Done!");
	}
}
