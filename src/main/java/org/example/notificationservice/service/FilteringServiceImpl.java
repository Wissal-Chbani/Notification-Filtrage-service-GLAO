package org.example.notificationservice.service;

import org.example.notificationservice.model.Opportunity;
import org.example.notificationservice.repository.OpportunityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FilteringServiceImpl implements FilteringService {
    private final OpportunityRepository opportunityRepository;

    public FilteringServiceImpl(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    @Override
    public List<Opportunity> filterBySector(String sector) {
        return opportunityRepository.findBySector(sector);
    }

    @Override
    public List<Opportunity> filterByLocation(String location) {
        return opportunityRepository.findByLocation(location);
    }

    @Override
    public List<Opportunity> filterByDeadline() {
        // Example: opportunities whose deadline is before 30 days
        LocalDate limitDate = LocalDate.now().plusDays(30);
        return opportunityRepository.findByDeadlineBefore(limitDate);
    }

}
