package cl.msapp.employee.service;

import cl.msapp.employee.entity.Employee;
import cl.msapp.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee employeeDB = getEmployee(employee.getId());
        if (employeeDB == null){
            return null;
        }
        employeeDB.setRut(employee.getRut());
        employeeDB.setNames(employee.getNames());
        employeeDB.setLastNames(employee.getLastNames());
        employeeDB.setBornDate(employee.getBornDate());
        employeeDB.setCategory(employee.getCategory());
        employeeDB.setEntryDate(employee.getEntryDate());
        return employeeRepository.save(employeeDB);
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Employee employeeDB = getEmployee(id);
        if (employeeDB == null){
            return null;
        }
        employeeRepository.delete(employeeDB);
        return employeeDB;
    }

    @Override
    public Employee findByRut(String rut) {
        return employeeRepository.findByRut(rut);
    }

    @Override
    public List<Employee> findByCategory(String category) {
        return employeeRepository.findByCategory(category);
    }

    @Override
    public List<Employee> findByEntryDate(String entryDate) {
        return employeeRepository.findByEntryDate(entryDate);
    }

    @Override
    public List<Employee> findByBornDate(String bornDate) {
        return employeeRepository.findByBornDate(bornDate);
    }

    @Override
    public void deleteByRut(String rut) {
        employeeRepository.deleteByRut(rut);
    }
}
