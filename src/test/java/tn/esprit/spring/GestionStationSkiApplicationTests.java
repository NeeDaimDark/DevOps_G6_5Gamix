package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.services.CourseServicesImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GestionStationSkiApplicationTests {

    @Autowired
    private CourseServicesImpl courseServices;

    /*@Test
    public void testAddCourse() {
        Course course = new Course();
        course.setName("Math");
        course.setDescription("Mathematics course");
        course.setCreditHours(3);
        course = courseServices.addCourse(course);

        assertNotNull(course.getId());
    }

    @Test
    public void testRetrieveCourse() {
        Course course = new Course();
        course.setName("Science");
        course.setDescription("Science course");
        course.setCreditHours(4);
        course = courseServices.addCourse(course);

        Course retrievedCourse = courseServices.retrieveCourse(course.getId());
        assertNotNull(retrievedCourse);
    }

    @Test
    public void testUpdateCourse() {
        Course course = new Course();
        course.setName("History");
        course.setDescription("History course");
        course.setCreditHours(3);
        course = courseServices.addCourse(course);

        // Update the course
        course.setName("Updated History Course");
        Course updatedCourse = courseServices.updateCourse(course);
        assertNotNull(updatedCourse);
    }*/
}