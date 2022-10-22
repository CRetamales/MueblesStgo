package cl.msapp.justification;

import cl.msapp.justification.entity.Justification;
import cl.msapp.justification.repository.JustificationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JustificationRepositoryMockTest {

    @Autowired
    private JustificationRepository justificationRepository;

    @Test
    public void whenFindByRut_thenReturnJustification() {
        // given
        Justification justification01 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification02 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification03 = Justification.builder()
                .rut("13345678-4")
                .date("2020-01-01")
                .category("C")
                .createdAt(new Date())
                .build();
        justificationRepository.save(justification01);
        justificationRepository.save(justification02);
        justificationRepository.save(justification03);
        // when
        Justification found = justificationRepository.findByRut(justification01.getRut()).get(0);
        List<Justification> founds= justificationRepository.findByRut(justification01.getRut());
        // then
        Assertions.assertThat(found.getRut()).isEqualTo(justification01.getRut());
        Assertions.assertThat(founds.size()).isEqualTo(2);
    }

    @Test
    public void whenFindByDate_thenReturnJustifications(){
        //given
        Justification justification01 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification02 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification03 = Justification.builder()
                .rut("13345678-4")
                .date("2020-05-01")
                .category("C")
                .createdAt(new Date())
                .build();
        justificationRepository.save(justification01);
        justificationRepository.save(justification02);
        justificationRepository.save(justification03);
        //when
        List<Justification> founds = justificationRepository.findByDate(justification01.getDate());
        //then
        Assertions.assertThat(founds.size()).isEqualTo(2);

    }

    @Test
    public void whenFindByCategory_thenReturnJustifications(){
        //given
        Justification justification01 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification02 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification03 = Justification.builder()
                .rut("13345678-4")
                .date("2020-05-01")
                .category("C")
                .createdAt(new Date())
                .build();
        justificationRepository.save(justification01);
        justificationRepository.save(justification02);
        justificationRepository.save(justification03);
        //when
        List<Justification> founds = justificationRepository.findByCategory(justification01.getCategory());
        //then
        Assertions.assertThat(founds.size()).isEqualTo(2);
    }

    @Test
    public void whenDeleteByRut_thenDeleteJustification(){
        //given
        Justification justification01 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification02 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification03 = Justification.builder()
                .rut("13345678-4")
                .date("2020-05-01")
                .category("C")
                .createdAt(new Date())
                .build();
        //when
        justificationRepository.save(justification01);
        justificationRepository.save(justification02);
        justificationRepository.save(justification03);
        //then
        justificationRepository.deleteByRut(justification01.getRut());
        List<Justification> founds01 = justificationRepository.findByRut(justification01.getRut());
        List<Justification> founds02 = justificationRepository.findAll();
        Assertions.assertThat(founds01.size()).isEqualTo(0);
        Assertions.assertThat(founds02.size()).isEqualTo(1);
    }

    @Test
    public void whenDeleteByDate_thenDeleteJustification(){
        //given
        Justification justification01 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification02 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification03 = Justification.builder()
                .rut("13345678-4")
                .date("2020-05-01")
                .category("C")
                .createdAt(new Date())
                .build();

        justificationRepository.save(justification01);
        justificationRepository.save(justification02);
        justificationRepository.save(justification03);
        //when
        justificationRepository.deleteByDate(justification01.getDate());
        List<Justification> founds01 = justificationRepository.findByDate(justification01.getDate());
        List<Justification> founds02 = justificationRepository.findAll();
        //then
        Assertions.assertThat(founds01.size()).isEqualTo(0);
        Assertions.assertThat(founds02.size()).isEqualTo(1);
    }

    @Test
    public void whenDeleteByCategory_thenDeleteJustification(){
        //given
        Justification justification01 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification02 = Justification.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .createdAt(new Date())
                .build();
        Justification justification03 = Justification.builder()
                .rut("13345678-4")
                .date("2020-05-01")
                .category("C")
                .createdAt(new Date())
                .build();
        justificationRepository.save(justification01);
        justificationRepository.save(justification02);
        justificationRepository.save(justification03);
        //when
        justificationRepository.deleteByCategory(justification01.getCategory());
        List<Justification> founds01 = justificationRepository.findByCategory(justification01.getCategory());
        List<Justification> founds02 = justificationRepository.findAll();
        //then
        Assertions.assertThat(founds01.size()).isEqualTo(0);
        Assertions.assertThat(founds02.size()).isEqualTo(1);
    }
}
