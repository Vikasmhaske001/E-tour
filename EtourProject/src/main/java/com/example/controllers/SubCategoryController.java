package com.example.controllers;

import com.example.models.SubCategoryMaster;
import com.example.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
@CrossOrigin(origins = "*")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping
    public SubCategoryMaster addSubCategory(@RequestBody SubCategoryMaster subCategory) {
        return subCategoryService.addSubCategory(subCategory);
    }

    @GetMapping
    public List<SubCategoryMaster> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    @GetMapping("/active")
    public List<SubCategoryMaster> getActiveSubCategories() {
        return subCategoryService.getActiveSubCategories();
    }

    @DeleteMapping("/{id}")
    public void deleteSubCategory(@PathVariable int id) {
        subCategoryService.deleteSubCategory(id);
    }
}
