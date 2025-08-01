package com.example.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Column(length = 80, nullable = false)
    private String custFirstName;

    @Column(length = 80, nullable = false)
    private String custLastName;
    
    @Column(length = 80, nullable = false, unique = true)
    private String custEmail;

    @Column(length = 15, nullable = false)
    private String custPhone;

    private Date custDob;

    @Column(length = 10)
    private String custGender;

    @Column(columnDefinition = "TEXT")
    private String custAddress;

    private String custCity;

    private String custState;

    private String custPincode;


    private Timestamp custCreatedAt;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<BookingHeader> bookings;
    
    @OneToOne(mappedBy = "customer")
    @JsonIgnore
    private Authentication authentication;
    
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<PaymentStatus> payments;


}
