package cl.msapp.report.client;


import cl.msapp.report.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "employee", path = "/employee")
public interface EmployeeClient {

    @GetMapping
    public ResponseEntity<List<Employee>> listEmployee();

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id);

}
