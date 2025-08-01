package com.example.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@Entity
@Table(name = "itinerarymaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itineraryId;

    private Integer dayNo;
    
    private String detailHeader;

    private String dayDetail;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private PackageMaster packageMaster;
}
