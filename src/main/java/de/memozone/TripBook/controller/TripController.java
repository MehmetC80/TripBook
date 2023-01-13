package de.memozone.TripBook.controller;


import de.memozone.TripBook.model.Trip;
import de.memozone.TripBook.service.TripService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/trip")
@AllArgsConstructor
public class TripController {
    @Autowired
    private final TripService tripService;
    private final Logger LOGGER = LoggerFactory.getLogger(TripController.class);

    @GetMapping
    public ResponseEntity<List<Trip>> fetchAllTrips() {
        LOGGER.info("Inside get All Trips of TripController");
        return ResponseEntity.ok(tripService.getAllTrips());
    }


    @GetMapping("/driver/{driver}")
    public ResponseEntity<List<Trip>> getTripWithDriverName(@PathVariable("driver") String driver) {

        return ResponseEntity.ok(tripService.getTripWithDriverName(driver));
    }

    @GetMapping("/{id}")
    public Optional<Trip> getSingleTrip(@PathVariable("id") String id) {
        LOGGER.info("Inside getSingleTripById of TripController");
        return tripService.getTripById(id);
    }


    @PostMapping
    public ResponseEntity saveTrip(@RequestBody Trip trip) {
        LOGGER.info("Inside saveTrip of TripController");
        tripService.saveTrip(trip);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/{id}")
    public String deleteTripById(@PathVariable("id") String tripId) {
        tripService.deleteTripById(tripId);
        LOGGER.info("Inside deleteTripById of TripController");
        return "Trip deleted successfully !!!";
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTrip(@PathVariable("id") String id, @RequestBody Trip trip) {
        LOGGER.info("Inside updateTrip of TripController");
        tripService.updateTrip(id,trip);
        return ResponseEntity.ok().build();
    }


}
