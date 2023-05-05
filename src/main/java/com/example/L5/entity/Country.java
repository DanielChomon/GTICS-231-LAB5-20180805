package com.example.L5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Set;

@Entity
@Getter
@Setter
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer country_id;
    @Column(name = "country_name", nullable = false)
    private String country_name;
    @ManyToOne
    @JoinColumn(name = "RegionID")
    private Region region;

}
