package org.example.notificationservice.service;

import org.example.notificationservice.model.Opportunity;

import java.util.List;

public interface FilteringService {
    List<Opportunity> filterBySector(String sector);

    List<Opportunity> filterByLocation(String location);

    List<Opportunity> filterByDeadline();
}
