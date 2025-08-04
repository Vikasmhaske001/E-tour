package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "categorymaster")

public class CategoryMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;

    @NotBlank(message = "Category name is required")
    private String catName;

    private String catImagePath;

    
    @Column(columnDefinition = "TINYINT(1)")
    private boolean flag = true;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SubCategoryMaster> subcategories;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatImagePath() {
		return catImagePath;
	}

	public void setCatImagePath(String catImagePath) {
		this.catImagePath = catImagePath;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public List<SubCategoryMaster> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<SubCategoryMaster> subcategories) {
		this.subcategories = subcategories;
	}
    
   
    
    
}
