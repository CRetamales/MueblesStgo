package cl.msapp.employee;

import cl.msapp.employee.entity.Employee;
import cl.msapp.employee.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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

    }

    @Test
    public void whenFindByEntryDate_thenReturnEmployees(){

    }

    @Test
    public void whenFindByBornDate_thenReturnEmployees(){

    }
}
