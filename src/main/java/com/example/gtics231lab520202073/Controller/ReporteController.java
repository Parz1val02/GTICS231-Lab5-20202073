package com.example.gtics231lab520202073.Controller;

import com.example.gtics231lab520202073.DTO.ReporteDTO;
import com.example.gtics231lab520202073.Repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
    final JobRepository jobRepository;

    public ReporteController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    };
    @GetMapping("/salario")
    public String salario(Model model){
        List<ReporteDTO> reporteSueldos = jobRepository.reporteSueldos();
        model.addAttribute("lista", reporteSueldos);
        return "reportes/Reporte - Sueldos";
    }
    @GetMapping("/aumento")
    public String aumento(){
        return "reportes/Reporte - Tentativa de Aumento";
    }
}
