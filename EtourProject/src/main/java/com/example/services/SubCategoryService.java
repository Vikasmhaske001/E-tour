package com.example.services;

import com.example.models.SubCategoryMaster;

import java.util.List;

public interface SubCategoryService {
    SubCategoryMaster addSubCategory(SubCategoryMaster subCategory);
    List<SubCategoryMaster> getAllSubCategories();
    List<SubCategoryMaster> getActiveSubCategories();
    void deleteSubCategory(int id);
}
