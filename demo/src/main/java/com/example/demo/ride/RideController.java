package com.example.demo.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideRepository rideRepository;

    @PostMapping
    public Ride createRide(@RequestBody Ride ride) {
        return rideRepository.save(ride);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable Long id) {
        Optional<Ride> ride = rideRepository.findById(id);
        return ride.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ride> updateRide(@PathVariable Long id, @RequestBody Ride updatedRide) {
        Optional<Ride> existingRideOptional = rideRepository.findById(id);
        if (existingRideOptional.isPresent()) {
            Ride existingRide = existingRideOptional.get();
            existingRide.setDriver(updatedRide.getDriver());
            existingRide.setCustomer(updatedRide.getCustomer());
            existingRide.setSource(updatedRide.getSource());
            existingRide.setDestination(updatedRide.getDestination());
            existingRide.setFare(updatedRide.getFare());

            Ride updated = rideRepository.save(existingRide);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRide(@PathVariable Long id) {
        Optional<Ride> ride = rideRepository.findById(id);
        if (ride.isPresent()) {
            rideRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }
}
