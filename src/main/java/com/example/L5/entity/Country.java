package main.java.com.example.L5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Shippers")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countryid")
    private Integer countryId;
    @Column(name = "countryname", nullable = false)
    private String countryname;
    @ManytoOne
    @JoinColumn(name = "RegionID")
    private Region region;

}
