package cl.msapp.employee.controller;

import cl.msapp.employee.entity.Employee;
import cl.msapp.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> listEmployee()
    {
        List<Employee> employees = employeeService.listAllEmployees();
        if(employees.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }
}
