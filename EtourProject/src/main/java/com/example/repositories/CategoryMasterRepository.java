package com.example.repositories;
import com.example.models.CategoryMaster;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMasterRepository extends JpaRepository<CategoryMaster, Integer> {
    @Query("select c from CategoryMaster c where c.flag = true")
    List<CategoryMaster> findActiveCategories();
}

