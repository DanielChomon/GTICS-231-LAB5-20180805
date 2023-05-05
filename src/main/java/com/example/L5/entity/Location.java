package com.example.L5.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "locations")
public class Location {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "locationID")
private int location_id;

@Column(nullable = false)
private String city;

private String state_province;

        }