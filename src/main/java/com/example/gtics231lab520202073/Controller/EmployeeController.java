package com.example.gtics231lab520202073.Controller;

import com.example.gtics231lab520202073.DTO.EmpleadoDTO;
import com.example.gtics231lab520202073.Entity.Department;
import com.example.gtics231lab520202073.Entity.Employee;
import com.example.gtics231lab520202073.Entity.Job;
import com.example.gtics231lab520202073.Repository.DepartmentRepository;
import com.example.gtics231lab520202073.Repository.EmployeeRepository;
import com.example.gtics231lab520202073.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empleados")
public class EmployeeController {
    @Autowired

    final EmployeeRepository employeeRepository;
    final DepartmentRepository departmentRepository;
    final JobRepository jobRepository;

    public EmployeeController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.jobRepository = jobRepository;
    }

    @GetMapping("")
    public String empleados(Model model){
        List<EmpleadoDTO> lista = employeeRepository.buscarEmpleado1();
        model.addAttribute("listaEmpleados", lista);
        return "empleados/Empleados Totales";
    }

    @GetMapping("/nuevo")
    public String nuevoArtista(Model model){
        List<Employee> jefes = employeeRepository.findAll();
        List<Job> puestos = jobRepository.findAll();
        List<Department> departamentos = departmentRepository.findAll();
        model.addAttribute("jefes", jefes);
        model.addAttribute("puestos", puestos);
        model.addAttribute("departamentos", departamentos);
        return "empleados/Nuevo Ingreso";
    }

    @PostMapping("/guardar")
    public String guardarArtista(@RequestParam("nombre")String nombre,
                                 @RequestParam("apellido")String apellido,
                                 @RequestParam("email")String email,
                                 @RequestParam("password")String password,
                                 @RequestParam("idpuesto")String idpuesto,
                                 @RequestParam("sueldo")Double sueldo,
                                 @RequestParam("idjefe")Integer idjefe,
                                 @RequestParam("iddepartamento")Integer iddepartamento,
                                 RedirectAttributes attr){
        employeeRepository.registrarEmpleado(nombre, apellido, email, password, idpuesto, sueldo, idjefe, iddepartamento);
        attr.addFlashAttribute("msg", "Empleado creado exitosamente");
        return "redirect:/empleados";
    }
    @PostMapping("/buscar")
    public String Buscar(@RequestParam("searchField") String searchField, Model model){
        List<EmpleadoDTO> lista = employeeRepository.buscarEmpleado(searchField);
        model.addAttribute("listaEmpleados", lista);
        model.addAttribute("filtro", searchField);
        return "empleados/Empleados Totales";
    }
    @GetMapping("/borrar")
    public String borrarArtista(Model model,
                                @RequestParam("id") Integer id,
                                RedirectAttributes attr) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isPresent()) {
            employeeRepository.deleteById(id);
        }
        attr.addFlashAttribute("msg", "Empleado borrado exitosamente");
        return "redirect:/empleados";
    }
}
