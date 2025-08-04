package com.example.services;

import com.example.models.ItineraryMaster;

import java.util.List;
import java.util.Optional;

public interface ItineraryMasterService {
    ItineraryMaster saveItinerary(ItineraryMaster itinerary);
    List<ItineraryMaster> getAllItineraries();
    Optional<ItineraryMaster> getItineraryById(int id);
    List<ItineraryMaster> getItinerariesByPackageId(int packageId);
    void deleteItinerary(int id);
}
