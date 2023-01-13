package de.memozone.TripBook.service;


import de.memozone.TripBook.model.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {

    public List<Trip> getAllTrips();

    public Trip saveTrip(Trip trip);


    public void deleteTripById(String tripId);

    Trip updateTrip(String id,Trip trip);


    List<Trip> getTripWithDriverName(String driver);

    Optional<Trip> getTripById(String id);
}

