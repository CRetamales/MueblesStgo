package cl.msapp.hour;

import cl.msapp.hour.entity.Hour;
import cl.msapp.hour.repository.HourRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HourRepositoryMockTest {

    @Autowired
    private HourRepository hourRepository;

    @Test
    public void whenFindByRut_thenReturnHour() {
        // given
        Hour hour01 = Hour.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour02 = Hour.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour03 = Hour.builder()
                .rut("13345678-4")
                .date("2020-01-01")
                .category("C")
                .created_at(new Date())
                .build();
        hourRepository.save(hour01);
        hourRepository.save(hour02);
        hourRepository.save(hour03);
        // when
        Hour found = hourRepository.findByRut(hour01.getRut()).get(0);
        List<Hour> founds= hourRepository.findByRut(hour01.getRut());
        // then
        Assertions.assertThat(found.getRut()).isEqualTo(hour01.getRut());
        Assertions.assertThat(founds.size()).isEqualTo(2);
    }

    @Test
    public void whenFindByDate_thenReturnHours(){
        //given
        Hour hour01 = Hour.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour02 = Hour.builder()
                .rut("12345618-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour03 = Hour.builder()
                .rut("19345678-1")
                .date("2020-01-02")
                .category("C")
                .created_at(new Date())
                .build();
        hourRepository.save(hour01);
        hourRepository.save(hour02);
        hourRepository.save(hour03);
        //when
        List<Hour> founds = hourRepository.findByDate(hour01.getDate());
        //then
        Assertions.assertThat(founds.size()).isEqualTo(2);
        Assertions.assertThat(founds.get(0).getDate()).isEqualTo(hour01.getDate());
    }

    @Test
    public void whenFindByCategory_thenReturnHours(){
        //given
        Hour hour01 = Hour.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour02 = Hour.builder()
                .rut("12345618-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour03 = Hour.builder()
                .rut("19345678-1")
                .date("2020-01-02")
                .category("A")
                .created_at(new Date())
                .build();
        hourRepository.save(hour01);
        hourRepository.save(hour02);
        hourRepository.save(hour03);
        //when
        List<Hour> founds = hourRepository.findByCategory(hour01.getCategory());
        //then
        Assertions.assertThat(founds.size()).isEqualTo(3);
        Assertions.assertThat(founds.get(0).getCategory()).isEqualTo(hour01.getCategory());
    }

    @Test
    public void whenDeleteByRut_thenDeleteHours(){
        //given
        Hour hour01 = Hour.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour02 = Hour.builder()
                .rut("12345618-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour03 = Hour.builder()
                .rut("19345678-1")
                .date("2020-01-02")
                .category("A")
                .created_at(new Date())
                .build();
        hourRepository.save(hour01);
        hourRepository.save(hour02);
        hourRepository.save(hour03);
        //when
        hourRepository.deleteByRut(hour01.getRut());
        //then
        Assertions.assertThat(hourRepository.findByRut(hour01.getRut()).size()).isEqualTo(0);
    }

    @Test
    public void whenDeleteByDate_thenDeleteHours(){
        //given
        Hour hour01 = Hour.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour02 = Hour.builder()
                .rut("12345618-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour03 = Hour.builder()
                .rut("19345678-1")
                .date("2020-01-02")
                .category("A")
                .created_at(new Date())
                .build();
        hourRepository.save(hour01);
        hourRepository.save(hour02);
        hourRepository.save(hour03);
        //when
        hourRepository.deleteByDate(hour01.getDate());
        //then
        Assertions.assertThat(hourRepository.findByDate(hour01.getDate()).size()).isEqualTo(0);
    }

    @Test
    public void whenDeleteByCategory_thenDeleteHours(){
        //given
        Hour hour01 = Hour.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour02 = Hour.builder()
                .rut("12345618-9")
                .date("2020-01-01")
                .category("A")
                .created_at(new Date())
                .build();
        Hour hour03 = Hour.builder()
                .rut("19345678-1")
                .date("2020-01-02")
                .category("A")
                .created_at(new Date())
                .build();
        hourRepository.save(hour01);
        hourRepository.save(hour02);
        hourRepository.save(hour03);
        //when
        hourRepository.deleteByCategory(hour01.getCategory());
        //then
        Assertions.assertThat(hourRepository.findByCategory(hour01.getCategory()).size()).isEqualTo(0);
    }
}
