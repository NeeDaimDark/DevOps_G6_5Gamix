package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestionStationSkiApplicationTests {

    @Mock
    private ICourseRepository courseRepository;

    @InjectMocks
    private CourseServicesImpl courseServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllCourses() {
        // Mock the behavior of the repository
        Course course1 = new Course();
        course1.setId(1L);
        Course course2 = new Course();
        course2.setId(2L);
        List<Course> courses = Arrays.asList(course1, course2);
        Mockito.when(courseRepository.findAll()).thenReturn(courses);

        // Test the service method
        List<Course> retrievedCourses = courseServices.retrieveAllCourses();

        // Assert the result
        assertEquals(2, retrievedCourses.size());
    }

    @Test
    public void testAddCourse() {
        // Mock the behavior of the repository
        Course course = new Course();
        Mockito.when(courseRepository.save(course)).thenReturn(course);

        // Test the service method
        Course addedCourse = courseServices.addCourse(course);

        // Assert the result
        assertEquals(course, addedCourse);
    }

    @Test
    public void testUpdateCourse() {
        // Mock the behavior of the repository
        Course course = new Course();
        Mockito.when(courseRepository.save(course)).thenReturn(course);

        // Test the service method
        Course updatedCourse = courseServices.updateCourse(course);

        // Assert the result
        assertEquals(course, updatedCourse);
    }

    @Test
    public void testRetrieveCourse() {
        // Mock the behavior of the repository
        Course course = new Course();
        course.setId(1L);
        Mockito.when(courseRepository.findById(1L)).thenReturn(java.util.Optional.of(course));

        // Test the service method
        Course retrievedCourse = courseServices.retrieveCourse(1L);

        // Assert the result
        assertEquals(course, retrievedCourse);
    }
}
