package com.example.services;

import com.example.models.PackageMaster;
import java.util.List;
import java.util.Optional;

public interface PackageMasterService {
    PackageMaster savePackage(PackageMaster pkg);
    List<PackageMaster> getAllPackages();
    Optional<PackageMaster> getPackageById(int id);
    void deletePackage(int id);
}
