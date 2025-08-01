package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "categorymaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;

    private String catName;

    private String catImagePath;

    private boolean flag;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<SubCategoryMaster> subcategories;
}
