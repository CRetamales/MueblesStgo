package cl.msapp.employee;

import cl.msapp.employee.entity.Employee;
import cl.msapp.employee.repository.EmployeeRepository;
import cl.msapp.employee.service.EmployeeService;
import cl.msapp.employee.service.EmployeeServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class EmployeeServiceMockTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    public void setup()
    {

        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImp(employeeRepository);
        Employee employee01 = Employee.builder()
                .id(1L)
                .rut("12345678-9")
                .names("Juan")
                .lastNames("Perez")
                .bornDate("01-01-1990")
                .category("A")
                .entryDate("01-01-2020")
                .build();

        Mockito.when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee01));
        Mockito.when(employeeRepository.save(employee01))
                .thenReturn(employee01);
    }

    @Test
    public void whenValidGetID_ThenReturnEmployee()
    {
        Employee found = employeeService.getEmployee(1L);
        Assertions.assertThat(found.getRut()).isEqualTo("12345678-9");
    }

}
