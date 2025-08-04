package com.example.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "subcategorymaster")

public class SubCategoryMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subcatId;


    private String subcatName;

    private String subcatImagePath;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean flag;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private CategoryMaster category;

    @OneToMany(mappedBy = "subCategory")
    @JsonIgnore
    private List<PackageMaster> packages;

	public int getSubcatId() {
		return subcatId;
	}

	public void setSubcatId(int subcatId) {
		this.subcatId = subcatId;
	}

	public String getSubcatName() {
		return subcatName;
	}

	public void setSubcatName(String subcatName) {
		this.subcatName = subcatName;
	}

	public String getSubcatImagePath() {
		return subcatImagePath;
	}

	public void setSubcatImagePath(String subcatImagePath) {
		this.subcatImagePath = subcatImagePath;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public CategoryMaster getCategory() {
		return category;
	}

	public void setCategory(CategoryMaster category) {
		this.category = category;
	}

	public List<PackageMaster> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageMaster> packages) {
		this.packages = packages;
	}
    
    
}