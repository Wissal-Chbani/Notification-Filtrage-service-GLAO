package org.example.notificationservice.controller;

import org.example.notificationservice.model.Opportunity;
import org.example.notificationservice.repository.OpportunityRepository;
import org.example.notificationservice.service.FilteringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunityController {

    private final OpportunityRepository opportunityRepository;
    private final FilteringService filteringService;

    public OpportunityController(OpportunityRepository opportunityRepository,
                                 FilteringService filteringService) {
        this.opportunityRepository = opportunityRepository;
        this.filteringService = filteringService;
    }

    // Create an opportunity
    @PostMapping
    public ResponseEntity<Opportunity> createOpportunity(
            @RequestBody Opportunity opportunity) {

        Opportunity saved = opportunityRepository.save(opportunity);
        return ResponseEntity.ok(saved);
    }

    // Get all opportunities
    @GetMapping
    public ResponseEntity<List<Opportunity>> getAllOpportunities() {
        return ResponseEntity.ok(opportunityRepository.findAll());
    }

    // Filter by sector
    @GetMapping("/filter/sector")
    public ResponseEntity<List<Opportunity>> filterBySector(
            @RequestParam String sector) {

        return ResponseEntity.ok(filteringService.filterBySector(sector));
    }

    // Filter by location
    @GetMapping("/filter/location")
    public ResponseEntity<List<Opportunity>> filterByLocation(
            @RequestParam String location) {

        return ResponseEntity.ok(filteringService.filterByLocation(location));
    }

    // Filter by deadline
    @GetMapping("/filter/deadline")
    public ResponseEntity<List<Opportunity>> filterByDeadline() {
        return ResponseEntity.ok(filteringService.filterByDeadline());
    }
}
