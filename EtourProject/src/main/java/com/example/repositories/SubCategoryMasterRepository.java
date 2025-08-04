package com.example.repositories;

import com.example.models.SubCategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryMasterRepository extends JpaRepository<SubCategoryMaster, Integer> {
    List<SubCategoryMaster> findByFlagTrue(); 
}
