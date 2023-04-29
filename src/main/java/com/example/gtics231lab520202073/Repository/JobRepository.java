package com.example.gtics231lab520202073.Repository;

import com.example.gtics231lab520202073.DTO.ReporteDTO;
import com.example.gtics231lab520202073.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query(nativeQuery = true, value = "select job_title as Puesto, min_salary as Minimo, max_salary as Maximo, sum(e.salary) as Total, round((sum(e.salary)/count(e.salary)),2) as Promedio from jobs j \n" +
            "inner join employees e on j.job_id=e.job_id\n" +
            "group by j.job_id")
    List<ReporteDTO> reporteSueldos();
}
