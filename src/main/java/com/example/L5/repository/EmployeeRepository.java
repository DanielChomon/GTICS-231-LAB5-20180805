package com.example.L5.repository;

import com.example.L5.entity.Employee;
import com.example.L5.dto.SalaryDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into `hr`.`employees` (`first_name`, `last_name`, `email`, `password`, `job_id`,`salary`, `manager_id`, `department_id`,`enabled` ) values ( ?1,?2,?3,?4,?5,?6,?7,?8,1) ",
            nativeQuery = true)
    void guardarEmpleado(String nombre, String apellido, String email, String contrasena, String puesto_id, double sueldo, int jefe_id, int departamento_id);



    @Transactional
    @Modifying
    @Query(value = "UPDATE `hr`.`employees` SET first_name = ?1, last_name = ?2, email = ?3 , password = ?4, job_id = ?5,salary = ?6, manager_id = ?7, department_id = ?8 where employee_id = ?9 ",
            nativeQuery = true)
    void editarEmpleado(String nombre, String apellido, String email, String contrasena, String puesto_id, double sueldo, int jefe_id, int departamento_id, int employee_id);


    @Query(value = "SELECT * FROM `hr`.`employees` WHERE enabled = 1",
            nativeQuery = true)
    List<Employee> listarEmpleados();

    @Transactional
    @Modifying
    @Query(value = "UPDATE `hr`.`employees` SET enabled = 0 where employee_id = ?1",
            nativeQuery = true)
    void borrarEmpleado(int employee_id);

    @Query(value = "SELECT e.* FROM employees e left join jobs j on j.job_id = e.job_id  left join departments d on d.department_id = e.department_id left join locations lo on lo.location_id = d.location_id WHERE( (lo.city like %?1%) or (e.first_name Like %?1%) or (e.last_name Like %?1%) or (j.job_title Like %?1%) )  AND enabled = 1",
            nativeQuery = true)
    List<Employee> buscarEmpleados(String searchText);


    @Query(value = "SELECT j.job_id, j.job_title, MAX(e.salary) as `maximo`, MIN(e.salary) as `minimo`, SUM(e.salary) as `salario_total`, truncate(AVG(e.salary),2) as `salario_promedio` FROM hr.employees e left join jobs j on j.job_id = e.job_id group by e.job_id",
            nativeQuery = true)
    List<SalaryDto> obtenerReporteSalarios();


}
