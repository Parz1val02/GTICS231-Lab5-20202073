package com.example.gtics231lab520202073.Controller;

import com.example.gtics231lab520202073.DTO.EmpleadoDTO;
import com.example.gtics231lab520202073.Entity.Employee;
import com.example.gtics231lab520202073.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@RequestMapping("/empleados")
public class EmployeeController {
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    final EmployeeRepository employeeRepository;
    @GetMapping("")
    public String empleados(Model model){
        List<EmpleadoDTO> lista = employeeRepository.buscarEmpleado1();
        model.addAttribute("listaEmpleados", lista);
        return "empleados/Empleados Totales";
    }

    @PostMapping("/buscar")
    public String Buscar(@RequestParam("searchField") String searchField, Model model){
        List<EmpleadoDTO> lista = employeeRepository.buscarEmpleado(searchField);
        model.addAttribute("listaEmpleados", lista);
        model.addAttribute("filtro", searchField);
        return "empleados/Empleados Totales";
    }
}
