package com.example.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "subcategorymaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subcatId;


    private String subcatName;

    private String subcatImagePath;

    private boolean flag;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private CategoryMaster category;

    @OneToMany(mappedBy = "subCategory")
    @JsonIgnore
    private List<PackageMaster> packages;
}