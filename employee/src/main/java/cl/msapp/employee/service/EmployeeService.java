package cl.msapp.employee.service;

import cl.msapp.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> listAllEmployees();
    public Employee getEmployee(Long id);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public Employee deleteEmployee(Long id);
    public Employee findByRut(String rut);
    public List<Employee> findByCategory(String category);
    public List<Employee> findByEntryDate(String entryDate);
    public List<Employee> findByBornDate(String bornDate);
    public void deleteByRut(String rut);
}
