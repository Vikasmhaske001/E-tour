package com.example.services;

import com.example.models.ItineraryMaster;
import com.example.repositories.ItineraryMasterRepository;
import com.example.services.ItineraryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryMasterServiceImpl implements ItineraryMasterService {

    @Autowired
    private ItineraryMasterRepository repository;

    @Override
    public ItineraryMaster saveItinerary(ItineraryMaster itinerary) {
        return repository.save(itinerary);
    }

    @Override
    public List<ItineraryMaster> getAllItineraries() {
        return repository.findAll();
    }

    @Override
    public Optional<ItineraryMaster> getItineraryById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<ItineraryMaster> getItinerariesByPackageId(int packageId) {
        return repository.findByPackageMaster_PackageId(packageId);
    }

    @Override
    public void deleteItinerary(int id) {
        repository.deleteById(id);
    }
}
