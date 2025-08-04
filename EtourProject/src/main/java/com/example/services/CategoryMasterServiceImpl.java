package com.example.services;

import com.example.models.CategoryMaster;
import com.example.repositories.CategoryMasterRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryMasterServiceImpl implements CategoryMasterService {

    private final CategoryMasterRepository categoryRepo;

    public CategoryMasterServiceImpl(CategoryMasterRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<CategoryMaster> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public CategoryMaster createCategory(CategoryMaster category) {
        return categoryRepo.save(category);
    }

    @Override
    public Optional<CategoryMaster> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public void deactivateCategory(int id) {
        CategoryMaster cat = getCategoryById(id)
            .orElseThrow(() -> new EntityNotFoundException("Category not found with id " + id));
        cat.setFlag(false);
        categoryRepo.save(cat);
    }

    @Override
    public List<CategoryMaster> getActiveCategories() {
        return categoryRepo.findActiveCategories();
    }
}
