package de.memozone.TripBook.repository;

import de.memozone.TripBook.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TripRepository extends MongoRepository<Trip, String> {


    //List<Trip>findTripByDriverName(String driver);
    @Query("{'driver': ?0}")
   Optional<List<Trip>> findTripByDriver(String driver);


}
