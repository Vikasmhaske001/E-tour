package com.example.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@Entity
@Table(name = "passenger")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paxId;

    private String paxName;

    private Date paxBirthdate;
    
    private int paxAge;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private PaxType paxType;

    private double paxAmount;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingHeader bookingHeader;
}