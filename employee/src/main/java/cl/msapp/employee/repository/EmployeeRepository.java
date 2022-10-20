package cl.msapp.employee.repository;

import cl.msapp.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByRut(String rut);
    public List<Employee> findByCategory(String category);
    public List<Employee> findByEntryDate(String entryDate);
    public List<Employee> findByBornDate(String bornDate);

}
