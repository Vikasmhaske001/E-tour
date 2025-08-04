package com.example.services;

import com.example.models.SubCategoryMaster;
import com.example.repositories.SubCategoryMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryMasterRepository subCategoryRepo;

    @Override
    public SubCategoryMaster addSubCategory(SubCategoryMaster subCategory) {
        return subCategoryRepo.save(subCategory);
    }

    @Override
    public List<SubCategoryMaster> getAllSubCategories() {
        return subCategoryRepo.findAll();
    }

    @Override
    public List<SubCategoryMaster> getActiveSubCategories() {
        return subCategoryRepo.findByFlagTrue();
    }

    @Override
    public void deleteSubCategory(int id) {
        subCategoryRepo.deleteById(id);
    }
}
