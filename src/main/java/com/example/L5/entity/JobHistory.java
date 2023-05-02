package main.java.com.example.L5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "job")
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobID")
    private int job_history_id;

    @ManytoOne
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

    private Date start_date;
    private Date end_date;

    @ManytoOne
    @JoinColumn(name = "JobID")
    private Job job;

    @ManytoOne
    @JoinColumn(name = "DeaprtmentID")
    private Department department;

}