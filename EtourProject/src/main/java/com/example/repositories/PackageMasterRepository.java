package com.example.repositories;

import com.example.models.PackageMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageMasterRepository extends JpaRepository<PackageMaster, Integer> {
   
}
