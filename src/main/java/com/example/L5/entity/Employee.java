package com.example.L5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int employee_id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String email;
    private String password;
    private String phone_number;
    @Column(nullable = false)
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name = "JobID")
    private Job job;

    private Float salary;
    private Float commission_pct;

    @OneToOne
    @JoinColumn(name = "reportsTo")
    private Employee manager;

    private Integer enabled;

}
