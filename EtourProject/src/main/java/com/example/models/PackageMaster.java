package com.example.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "packagemaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    private String packageName;

    private String packageInfo;

    private String packageImagePath;

    private Integer durationDays;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "subcat_id")
    private SubCategoryMaster subCategory;

    @OneToMany(mappedBy = "packageMaster")
    @JsonIgnore
    private List<ItineraryMaster> itineraries;

    @OneToMany(mappedBy = "packageMaster")
    @JsonIgnore
    private List<CostMaster> costs;

    @OneToMany(mappedBy = "packageMaster")
    @JsonIgnore
    private List<Departure> departures;

    @OneToMany(mappedBy = "packageMaster")
    @JsonIgnore
    private List<BookingHeader> bookings;
}
