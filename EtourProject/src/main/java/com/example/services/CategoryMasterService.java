package com.example.services;

import com.example.models.CategoryMaster;

import java.util.List;
import java.util.Optional;

public interface CategoryMasterService {
    List<CategoryMaster> getAllCategories();
    CategoryMaster createCategory(CategoryMaster category);
    Optional<CategoryMaster> getCategoryById(int id);
    void deactivateCategory(int id);
    List<CategoryMaster> getActiveCategories();
}

