package com.nsanegg.cruddemo;

import com.nsanegg.cruddemo.dao.AppDao;
import com.nsanegg.cruddemo.entity.Course;
import com.nsanegg.cruddemo.entity.Instructor;
import com.nsanegg.cruddemo.entity.InstructorDetail;
import com.nsanegg.cruddemo.entity.Review;
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
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			/*createCourseAndReviews(appDao);*/
			retrieveCourseAndReviews(appDao);
		};
	}

	private void retrieveCourseAndReviews(AppDao appDao) {

		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDao.findCourseAndReviewByCourseId(theId);
		// print the course
		System.out.println(tempCourse);
		// print the reviews
		System.out.println(tempCourse.getReviews());
		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDao appDao) {

		// create a course
		Course tempCourse = new Course("Genshin Impact");
		// add some reviews
		tempCourse.addReview(new Review("Fk this game"));
		tempCourse.addReview(new Review("Love this game"));
		tempCourse.addReview(new Review("Hate this game"));
		tempCourse.addReview(new Review("Delete this game"));

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDao.save(tempCourse);
		// save the course
	}

	private void deleteCourse(AppDao appDao) {
		int thId = 10;
		System.out.println("Deleting course id: " + thId);
		appDao.deleteCourseById(thId);
		System.out.println("Done");
	}

	private void updateCourse(AppDao appDao) {

		int theId = 10;
		// find the course
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDao.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Enjoy the simple things");
		appDao.update(tempCourse);
		System.out.println("Done");
	}

	private void updateInstructor(AppDao appDao) {
		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id:" + theId);
		tempInstructor.setLastName("Junior");
		appDao.update(tempInstructor);
		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
		int theId = 1;

		// find the instructor
		System.out.println("Finding intructor id: " + theId);
		Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDao appDao) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDao.findCoursesByInstructorId(theId);
		// associated the object
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println(("the associated courses: " + tempInstructor.getCourses()));
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDao appDao) {
		// create the instructor
		Instructor tempInstructor = new Instructor("KyJr", "Dang Hong", "ky2222@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.MrKy.com/youtube", "videogames");

		// associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Horizon Zero Dawn");
		Course tempCourse2 = new Course("Horizon Forbidden West");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDao.save(tempInstructor);
		System.out.println("Done!");
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
