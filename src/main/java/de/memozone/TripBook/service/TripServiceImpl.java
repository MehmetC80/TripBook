package de.memozone.TripBook.service;

import de.memozone.TripBook.model.Trip;
import de.memozone.TripBook.repository.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private final TripRepository tripRepository;


    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip saveTrip(Trip trip) {
        return tripRepository.insert(trip);
    }

    @Override
    public void deleteTripById(String tripId) {
        tripRepository.deleteById(tripId);
    }

    @Override
    public Trip updateTrip(String id,Trip trip) {

        Trip savedTripinDB = tripRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Trip by ID %s", trip.getId())));

        savedTripinDB.setFrom(trip.getFrom());
        savedTripinDB.setTo(trip.getTo());
        savedTripinDB.setKmBegin(trip.getKmBegin());
        savedTripinDB.setKmEnd(trip.getKmEnd());
        savedTripinDB.setRoute(trip.getRoute());
        savedTripinDB.setPrivat(trip.getPrivat());
        savedTripinDB.setPurpose(trip.getPurpose());
        savedTripinDB.setDriver(trip.getDriver());
        savedTripinDB.setVehicle(trip.getVehicle());
        return tripRepository.save(trip);
    }

    @Override
    public List<Trip> getTripWithDriverName(String driver) {

        return tripRepository.findTripByDriver(driver).orElseThrow(() -> new RuntimeException(String.format("Can not find driver with name", driver)));
    }

    @Override
    public Optional<Trip> getTripById(String id) {
        Optional<Trip> tripDB = tripRepository.findById(id);

        return tripDB;
    }


}



