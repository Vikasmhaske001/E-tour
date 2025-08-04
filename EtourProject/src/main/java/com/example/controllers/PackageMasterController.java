package com.example.controllers;

import com.example.models.PackageMaster;
import com.example.services.PackageMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = "*")
public class PackageMasterController {

    @Autowired
    private PackageMasterService packageService;

    @PostMapping
    public ResponseEntity<PackageMaster> createPackage(@RequestBody PackageMaster pkg) {
        return ResponseEntity.ok(packageService.savePackage(pkg));
    }

    @GetMapping
    public ResponseEntity<List<PackageMaster>> getAllPackages() {
        return ResponseEntity.ok(packageService.getAllPackages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageMaster> getPackageById(@PathVariable int id) {
        return packageService.getPackageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable int id) {
        packageService.deletePackage(id);
        return ResponseEntity.noContent().build();
    }
}
