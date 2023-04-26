package com.example.gtics231lab520202073.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
    @GetMapping("/")
    public String principal(){
        return "Recursos Humanos - TravelTrip";
    }
}

