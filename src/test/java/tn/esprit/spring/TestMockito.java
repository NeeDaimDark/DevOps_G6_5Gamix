package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.SkierServicesImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SkierServiceTest {

    @InjectMocks
    SkierServicesImpl skierServices;

    @Mock
    ISkierRepository skierRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllSkiers() {
        // Prepare mock data
        Skier skier1 = new Skier(1L, "John", "Doe", LocalDate.of(1990, 5, 15), "City1", new Subscription(), new HashSet<>(), new HashSet<>());
        Skier skier2 = new Skier(2L, "Alice", "Smith", LocalDate.of(1985, 8, 25), "City2", new Subscription(), new HashSet<>(), new HashSet<>());
        List<Skier> skiers = Arrays.asList(skier1, skier2);

        // Configure the behavior of the mock
        Mockito.when(skierRepository.findAll()).thenReturn(skiers);

        // Call the service method
        List<Skier> retrievedSkiers = skierServices.retrieveAllSkiers();

        // Assertions
        assertNotNull(retrievedSkiers);
        assertEquals(2, retrievedSkiers.size());
    }

    @Test
    void testRetrieveSkierByNumSkier() {
        // Prepare mock data
        Long numSkier = 1L;
        Skier skier = new Skier(numSkier, "John", "Doe", LocalDate.of(1990, 5, 15), "City1", new Subscription(), new HashSet<>(), new HashSet<>());

        // Configure the behavior of the mock
        Mockito.when(skierRepository.findByNumSkier(numSkier)).thenReturn(skier);

        // Call the service method
        Skier retrievedSkier = skierServices.retrieveSkierByNumSkier(numSkier);

        // Assertions
        assertNotNull(retrievedSkier);
        assertEquals(numSkier, retrievedSkier.getNumSkier());
    }

    // Add more test methods for other service methods as needed
}
