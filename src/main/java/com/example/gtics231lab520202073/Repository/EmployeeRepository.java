package com.example.gtics231lab520202073.Repository;

import com.example.gtics231lab520202073.Entity.Employee;
import com.example.gtics231lab520202073.DTO.EmpleadoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e.employee_id as id, e.first_name as Nombre, e.last_name as Apellido, j.job_title as Puesto, d.department_name as Departamento, l.city as Ciudad from employees e \n" +
            "inner join jobs j on e.job_id=j.job_id\n" +
            "inner join departments d on e.department_id=d.department_id\n" +
            "inner join locations l on d.location_id=l.location_id where e.enabled=1 order by e.employee_id",
            nativeQuery = true)
    List<EmpleadoDTO> buscarEmpleado1();
    @Query(value = "select e.employee_id as id, e.first_name as Nombre, e.last_name as Apellido, j.job_title as Puesto, d.department_name as Departamento, l.city as Ciudad from employees e \n" +
            "inner join jobs j on e.job_id=j.job_id\n" +
            "inner join departments d on e.department_id=d.department_id\n" +
            "inner join locations l on d.location_id=l.location_id\n" +
            "where lower(e.first_name) like %?1% or lower(e.last_name) like %?1% or lower(j.job_title) like %?1% or lower(d.department_name) like %?1% or lower(l.city) like %?1% and e.enabled=1 order by e.employee_id",
            nativeQuery = true)
    List<EmpleadoDTO> buscarEmpleado(String searchField);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "Insert into employees(first_name, last_name, email, password, hire_date, job_id, salary, manager_id, department_id, enabled) values (?1, ?2, ?3, sha2(?4, 256), current_timestamp(), ?5, ?6, ?7, ?8,1)")
    void registrarEmpleado(String nombre, String apellido, String email, String password, String idjob, Double sueldo, Integer idmanager, Integer iddepartment);
}