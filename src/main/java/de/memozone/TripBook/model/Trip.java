package de.memozone.TripBook.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Trip {


    @Id
    private String id;
    private LocalDateTime from;
    private LocalDateTime to;
    private Integer kmBegin;
    private Integer kmEnd;
    private String route;
    private String purpose;
    private Boolean privat;
    private String driver;
    private String vehicle;

    public Trip(LocalDateTime from, LocalDateTime to, Integer kmBegin, Integer kmEnd, String route, String purpose, Boolean privat, String driver, String vehicle) {
        this.from = from;
        this.to = to;
        this.kmBegin = kmBegin;
        this.kmEnd = kmEnd;
        this.route = route;
        this.purpose = purpose;
        this.privat = privat;
        this.driver = driver;
        this.vehicle = vehicle;
    }
}

