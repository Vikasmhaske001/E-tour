package com.example.controllers;

import com.example.models.ItineraryMaster;
import com.example.services.ItineraryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryMasterController {

    @Autowired
    private ItineraryService service;

   

    @GetMapping
    public ResponseEntity<List<ItineraryMaster>> getAllItineraries() {
        return ResponseEntity.ok(service.getAllItineraries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItineraryMaster> getItineraryById(@PathVariable int id) {
        return service.getItineraryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<ItineraryMaster>> getByPackageId(@PathVariable int packageId) {
        return ResponseEntity.ok(service.getItinerariesByPackageId(packageId));
    }

   
}
