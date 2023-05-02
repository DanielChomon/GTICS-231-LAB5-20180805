package main.java.com.example.L5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobID")
    private int job_id;

    @Column(nullable = false)
    private String job_title;

    private Integer min_salary;
    private Integer max_salary;

}