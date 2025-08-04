package com.example.services;

import com.example.models.PackageMaster;
import com.example.repositories.PackageMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageMasterServiceImpl implements PackageMasterService {

    @Autowired
    private PackageMasterRepository packageRepo;

    @Override
    public PackageMaster savePackage(PackageMaster pkg) {
        return packageRepo.save(pkg);
    }

    @Override
    public List<PackageMaster> getAllPackages() {
        return packageRepo.findAll();
    }

    @Override
    public Optional<PackageMaster> getPackageById(int id) {
        return packageRepo.findById(id);
    }

    @Override
    public void deletePackage(int id) {
        packageRepo.deleteById(id);
    }
}
