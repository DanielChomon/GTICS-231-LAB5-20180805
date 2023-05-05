package com.example.L5.controller;

import com.example.L5.dto.SalaryDto;
import com.example.L5.repository.DepartmentRepository;
import com.example.L5.repository.EmployeeRepository;
import com.example.L5.repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


import com.example.L5.dto.SalaryDto;

public class ReportController {

    final EmployeeRepository employeeRepository;
    final DepartmentRepository departmentRepository;
    final JobRepository jobRepository;
    public ReportController(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository,JobRepository jobRepository ) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.jobRepository = jobRepository;
    }


    @GetMapping("/reportes")
    public String inicioReportes(){
        return "reportes/listar";
    }



    @GetMapping("/reportes/salario")
    public String reportesSalario(Model model){
        List<SalaryDto> listaSalarios = employeeRepository.obtenerReporteSalarios();
        model.addAttribute("listaSalarios",listaSalarios);
        return "reportes/salario";
    }

    @GetMapping("/reportes/aumento")
    public String reportesAumento(){
        return "reportes/aumento";
    }



}
