package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.*;
import tn.esprit.spring.services.SkierServicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TestMockito {

    @Mock
    ISkierRepository skierRepository;

    @Mock
    ISubscriptionRepository subscriptionRepository;

    @Mock
    ICourseRepository courseRepository;

    @Mock
    IRegistrationRepository registrationRepository;

    @Mock
    IPisteRepository pisteRepository;

    @InjectMocks
    SkierServicesImpl skierServices;

    @Test
    void testRetrieveAllSkiers() {
        List<Skier> skierList = new ArrayList<>();
        // Populate skierList with sample data

        Mockito.when(skierRepository.findAll()).thenReturn(skierList);

        List<Skier> result = skierServices.retrieveAllSkiers();

        Assertions.assertEquals(skierList, result);
    }


    @Test
    void testAssignSkierToSubscription() {
        Long numSkier = 1L;
        Long numSubscription = 2L;
        Skier skier = new Skier();
        Subscription subscription = new Subscription();
        // Populate skier and subscription with sample data

        Mockito.when(skierRepository.findById(numSkier)).thenReturn(Optional.of(skier));
        Mockito.when(subscriptionRepository.findById(numSubscription)).thenReturn(Optional.of(subscription));
        Mockito.when(skierRepository.save(skier)).thenReturn(skier);

        Skier result = skierServices.assignSkierToSubscription(numSkier, numSubscription);

        // Add your assertions here
    }

    // Implement similar test methods for other functions

    @Test
    void testRemoveSkier() {
        Long numSkier = 1L;

        skierServices.removeSkier(numSkier);

        Mockito.verify(skierRepository, Mockito.times(1)).deleteById(numSkier);
    }

    @Test
    void testRetrieveSkier() {
        Long numSkier = 1L;
        Skier skier = new Skier();
        // Populate skier with sample data

        Mockito.when(skierRepository.findById(numSkier)).thenReturn(Optional.of(skier));

        Skier result = skierServices.retrieveSkier(numSkier);

        // Add your assertions here
    }

    @Test
    void testAssignSkierToPiste() {
        Long numSkieur = 1L;
        Long numPiste = 2L;
        Skier skier = new Skier();
        Piste piste = new Piste();
        // Populate skier and piste with sample data

        Mockito.when(skierRepository.findById(numSkieur)).thenReturn(Optional.of(skier));
        Mockito.when(pisteRepository.findById(numPiste)).thenReturn(Optional.of(piste));
        Mockito.when(skierRepository.save(skier)).thenReturn(skier);

        Skier result = skierServices.assignSkierToPiste(numSkieur, numPiste);

        // Add your assertions here
    }

    @Test
    void testRetrieveSkiersBySubscriptionType() {
        TypeSubscription typeSubscription = TypeSubscription.ANNUAL;
        List<Skier> skierList = new ArrayList<>();
        // Populate the skierList with sample data

        Mockito.when(skierRepository.findBySubscription_TypeSub(typeSubscription)).thenReturn(skierList);

        List<Skier> result = skierServices.retrieveSkiersBySubscriptionType(typeSubscription);

        Assertions.assertEquals(skierList, result);
    }
}
