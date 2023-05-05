package com.example.L5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name="Products")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="departmentID")
    private int department_id;
    @Column(nullable = false)
    private String department_name;
    @ManyToOne
    @JoinColumn(name = "ManagerID")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location location;

}
