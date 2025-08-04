package com.example.controllers;

import com.example.models.CategoryMaster;
import com.example.services.CategoryMasterService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryMasterController {

    private final CategoryMasterService categoryService;

    @Autowired
    public CategoryMasterController(CategoryMasterService categoryService) {
        this.categoryService = categoryService;
    }

    // Get all categories (including inactive)
    @GetMapping
    public ResponseEntity<List<CategoryMaster>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // Get category by ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryMaster> getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id " + id));
    }

    // Create a new category
    @PostMapping
    public ResponseEntity<CategoryMaster> createCategory(@Valid @RequestBody CategoryMaster category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    // Deactivate a category (soft delete)
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateCategory(@PathVariable int id) {
        categoryService.getCategoryById(id).orElseThrow(
                () -> new EntityNotFoundException("Category not found with id " + id)
        );
        CategoryMaster category = categoryService.getCategoryById(id).get();
        category.setFlag(false);
        categoryService.createCategory(category); // update
        return ResponseEntity.noContent().build();
    }

    // Get only active categories
    @GetMapping("/active")
    public ResponseEntity<List<CategoryMaster>> getActiveCategories() {
        return ResponseEntity.ok(categoryService.getActiveCategories());
    }
}
