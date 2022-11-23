package cl.msapp.employee.controller;

import cl.msapp.employee.entity.Employee;
import cl.msapp.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
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
        log.info("Buscando empleado con id: {}", id);
        Employee employee = employeeService.getEmployee(id);
        if(employee == null)
        {
            log.error("Empleado con id: {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee, BindingResult result)
    {
        log.info("Creando empleado: {}", employee);
        if(result.hasErrors())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Employee employeeDB = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee)
    {
        log.info("Actualizando empleado con id: {}", id);
        Employee employeeDB = employeeService.findByRut(employee.getRut());
        if(employeeDB == null)
        {
            log.error("No se pudo actualizar. Empleado con id: {} no encontrado", id);
            return ResponseEntity.notFound().build();
        }
        employeeDB.setId(employee.getId());
        return ResponseEntity.ok(employeeDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id)
    {
        log.info("Eliminando empleado con id: {}", id);
        Employee employeeDB = employeeService.deleteEmployee(id);
        if(employeeDB == null)
        {
            log.error("No se pudo eliminar. Empleado con id: {} no encontrado", id);
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

    @GetMapping("/export")
    public void export() throws JsonProcessingException {
        List<Employee> employees = employeeService.listAllEmployees();
        employeeService.exportToXls(employees);
    }



    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try{
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return jsonString;
    }



}
