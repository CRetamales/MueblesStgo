package cl.msapp.employee;

import cl.msapp.employee.entity.Employee;
import cl.msapp.employee.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryMockTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByRut_thenReturnEmployee() {
        // given
        Employee employee01 = Employee.builder()
                .rut("12345678-9")
                .names("Juan Tomas")
                .lastNames("Perez Gonzalez")
                .bornDate("1990-01-01")
                .category("A")
                .entryDate("2020-01-01")
                .build();
        employeeRepository.save(employee01);
        // when
        Employee found = employeeRepository.findByRut(employee01.getRut());
        // then
        Assertions.assertThat(found.getRut()).isEqualTo(employee01.getRut());
    }

    @Test
    public void whenFindByCategory_thenReturnEmployees(){
        //given
        Employee employee01 = Employee.builder()
                .rut("12345678-9")
                .names("Juan Tomas")
                .lastNames("Perez Gonzalez")
                .bornDate("1990-01-01")
                .category("A")
                .entryDate("2020-01-01")
                .build();
        Employee employee02 = Employee.builder()
                .rut("12345618-9")
                .names("Tomas Pablo")
                .lastNames("Gonzalez Ramirez")
                .bornDate("1995-01-01")
                .category("A")
                .entryDate("2018-01-01")
                .build();
        Employee employee03 = Employee.builder()
                .rut("19345678-1")
                .names("Pedro Sebastian")
                .lastNames("Palominos Gonzalez")
                .bornDate("1965-02-02")
                .category("C")
                .entryDate("2010-12-12")
                .build();
        employeeRepository.save(employee01);
        employeeRepository.save(employee02);
        employeeRepository.save(employee03);
        //when
        List<Employee> founds = employeeRepository.findByCategory("A");
        //then
        Assertions.assertThat(founds.size()).isEqualTo(2);

    }

    @Test
    public void whenFindByEntryDate_thenReturnEmployees(){
        //give
        Employee employee01 = Employee.builder()
                .rut("12345678-9")
                .names("Juan Tomas")
                .lastNames("Perez Gonzalez")
                .bornDate("1990-01-01")
                .category("A")
                .entryDate("2020-01-01")
                .build();
        Employee employee02 = Employee.builder()
                .rut("12345618-9")
                .names("Tomas Pablo")
                .lastNames("Gonzalez Ramirez")
                .bornDate("1995-01-01")
                .category("A")
                .entryDate("2020-01-01")
                .build();
        Employee employee03 = Employee.builder()
                .rut("19345678-1")
                .names("Pedro Sebastian")
                .lastNames("Palominos Gonzalez")
                .bornDate("1965-02-02")
                .category("C")
                .entryDate("2020-01-01")
                .build();
        employeeRepository.save(employee01);
        employeeRepository.save(employee02);
        employeeRepository.save(employee03);
        //when
        List<Employee> founds = employeeRepository.findByEntryDate("2020-01-01");
        //then
        Assertions.assertThat(founds.size()).isEqualTo(3);
    }

    @Test
    public void whenFindByBornDate_thenReturnEmployees(){
        //give
        Employee employee01 = Employee.builder()
                .rut("12345678-9")
                .names("Juan Tomas")
                .lastNames("Perez Gonzalez")
                .bornDate("1990-01-01")
                .category("A")
                .entryDate("2020-01-01")
                .build();
        Employee employee02 = Employee.builder()
                .rut("12345618-9")
                .names("Tomas Pablo")
                .lastNames("Gonzalez Ramirez")
                .bornDate("1995-01-01")
                .category("A")
                .entryDate("2020-01-01")
                .build();
        Employee employee03 = Employee.builder()
                .rut("19345678-1")
                .names("Pedro Sebastian")
                .lastNames("Palominos Gonzalez")
                .bornDate("1965-02-02")
                .category("C")
                .entryDate("2020-01-01")
                .build();
        employeeRepository.save(employee01);
        employeeRepository.save(employee02);
        employeeRepository.save(employee03);
        //when
        Employee found = employeeRepository.findByBornDate("1965-02-02").get(0);
        //then
        Assertions.assertThat(found.getBornDate()).isEqualTo(employee03.getBornDate());
    }


    @Test
    public void whenDeleteByRut_thenDeleteEmployee(){
        //given
        Employee employee01 = Employee.builder()
                .rut("12345678-9")
                .names("Juan Tomas")
                .lastNames("Perez Gonzalez")
                .bornDate("1990-01-01")
                .category("A")
                .entryDate("2020-01-01")
                .build();
        employeeRepository.save(employee01);
        //when
        employeeRepository.deleteByRut(employee01.getRut());
        //then
        Assertions.assertThat(employeeRepository.findByRut(employee01.getRut())).isNull();
    }
}
