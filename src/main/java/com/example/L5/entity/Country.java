package main.java.com.example.L5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "country_name", nullable = false)
    private String country_name;
    @ManytoOne
    @JoinColumn(name = "RegionID")
    private Region region;

}
