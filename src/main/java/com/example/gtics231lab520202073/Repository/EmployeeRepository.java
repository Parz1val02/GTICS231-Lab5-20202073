package com.example.gtics231lab520202073.Repository;

import com.example.gtics231lab520202073.Entity.Employee;
import com.example.gtics231lab520202073.DTO.EmpleadoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e.employee_id as id, e.first_name as Nombre, e.last_name as Apellido, j.job_title as Puesto, d.department_name as Departamento, l.city as Ciudad from employees e \n" +
            "inner join jobs j on e.job_id=j.job_id\n" +
            "inner join departments d on e.department_id=d.department_id\n" +
            "inner join locations l on d.location_id=l.location_id;",
            nativeQuery = true)
    List<EmpleadoDTO> buscarEmpleado1();
    @Query(value = "select e.employee_id as id, e.first_name as Nombre, e.last_name as Apellido, j.job_title as Puesto, d.department_name as Departamento, l.city as Ciudad from employees e \n" +
            "inner join jobs j on e.job_id=j.job_id\n" +
            "inner join departments d on e.department_id=d.department_id\n" +
            "inner join locations l on d.location_id=l.location_id\n" +
            "where e.first_name like %?1% or e.last_name like %?1% or j.job_title like %?1% or d.department_name like %?1% or l.city like %?1%;",
            nativeQuery = true)
    List<EmpleadoDTO> buscarEmpleado(String wenas);
}