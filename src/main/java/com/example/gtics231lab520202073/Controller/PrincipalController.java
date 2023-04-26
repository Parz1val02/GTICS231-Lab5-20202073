package com.example.gtics231lab520202073.Controller;

import com.example.gtics231lab520202073.Repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PrincipalController {
    @GetMapping("/")
    public String principal(){
        return "Recursos Humanos - TravelTrip";
    }

    @GetMapping("/historial")
    public String historial(){
        return "historial";
    }

    @GetMapping("/reportes")
    public String reportes(){
        return "reportes";
    }
}

