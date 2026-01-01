package org.example.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "opportunities")
public class Opportunity {
    private String id;
    private String title;
    private String sector;
    private Double amount;
    private String location;
    private LocalDate deadline;

    public static void main(String[] args) {
        Opportunity op = Opportunity.builder()
                .title("New Tender")
                .sector("Construction")
                .amount(50000.0)
                .location("Rabat")
                .deadline(LocalDate.of(2026, 1, 15))
                .build();

        System.out.println(op);
    }
}
