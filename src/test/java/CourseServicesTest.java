

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.entities.Support;  // Add this import statement
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CourseServicesTest {

    @InjectMocks
    CourseServicesImpl courseServices;

    @Mock
    ICourseRepository courseRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllCourses() {
        // Prepare mock data
        Course course1 = new Course(1L, 1, TypeCourse.COLLECTIVE_CHILDREN, Support.SKI, 100.0F, 60, null);
        Course course2 = new Course(2L, 2, TypeCourse.COLLECTIVE_ADULT, Support.SNOWBOARD, 150.0F, 90, null);
        List<Course> courses = Arrays.asList(course1, course2);

        // Configure the behavior of the mock
        Mockito.when(courseRepository.findAll()).thenReturn(courses);

        // Call the service method
        List<Course> retrievedCourses = courseServices.retrieveAllCourses();

        // Assertions
        assertNotNull(retrievedCourses);
        assertEquals(2, retrievedCourses.size());
    }

    // Add more test methods for other service methods as needed
}
