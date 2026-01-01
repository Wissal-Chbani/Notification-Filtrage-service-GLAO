package org.example.notificationservice;


import org.example.notificationservice.model.Opportunity;
import org.example.notificationservice.repository.OpportunityRepository;
import org.example.notificationservice.service.FilteringServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FilteringServiceImplTest {

    @Mock
    private OpportunityRepository opportunityRepository;

    @InjectMocks
    private FilteringServiceImpl filteringService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFilterBySector() {
        Opportunity op1 = new Opportunity("1","Tender1","IT",5000.0,"Rabat", LocalDate.now());
        Opportunity op2 = new Opportunity("2","Tender2","Construction",10000.0,"Casablanca", LocalDate.now());
        when(opportunityRepository.findBySector("IT")).thenReturn(Arrays.asList(op1));

        List<Opportunity> result = filteringService.filterBySector("IT");
        assertEquals(1, result.size());
        assertEquals("IT", result.get(0).getSector());
    }
}
