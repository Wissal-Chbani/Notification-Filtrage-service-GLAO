package org.example.notificationservice.repository;

import org.example.notificationservice.model.Opportunity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends MongoRepository<Opportunity,String> {
    List<Opportunity> findBySector(String sector);

    List<Opportunity> findByLocation(String location);

    List<Opportunity> findByDeadlineBefore(java.time.LocalDate date);
}
