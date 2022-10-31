package cl.msapp.employee.controller;

import cl.msapp.employee.entity.Employee;
import cl.msapp.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id)
    {
        Employee employee = employeeService.getEmployee(id);
        if(employee == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        Employee employeeDB = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee)
    {
        employee.setId(id);
        Employee employeeDB = employeeService.updateEmployee(employee);
        if(employeeDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id)
    {
        Employee employeeDB = employeeService.deleteEmployee(id);
        if(employeeDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeDB);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<Employee> findByRut(@PathVariable("rut") String rut)
    {
        Employee employeeDB = employeeService.findByRut(rut);
        if(employeeDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeDB);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Employee>> findByCategory(@PathVariable("category") String category)
    {
        List<Employee> employees = employeeService.findByCategory(category);
        if(employees.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/entryDate/{entryDate}")
    public ResponseEntity<List<Employee>> findByEntryDate(@PathVariable("entryDate") String entryDate)
    {
        List<Employee> employees = employeeService.findByEntryDate(entryDate);
        if(employees.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/bornDate/{bornDate}")
    public ResponseEntity<List<Employee>> findByBornDate(@PathVariable("bornDate") String bornDate)
    {
        List<Employee> employees = employeeService.findByBornDate(bornDate);
        if(employees.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/rut/{rut}")
    public ResponseEntity<Employee> deleteByRut(@PathVariable("rut") String rut)
    {
        employeeService.deleteByRut(rut);
        return ResponseEntity.ok().build();
    }



}
