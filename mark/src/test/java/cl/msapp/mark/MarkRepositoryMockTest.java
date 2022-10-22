package cl.msapp.mark;


import cl.msapp.mark.entity.Mark;
import cl.msapp.mark.repository.MarkRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MarkRepositoryMockTest {

    @Autowired
    private MarkRepository markRepository;

    @Test
    public void whenFindByRut_thenReturnMark() {
        // given
        Mark mark01 = Mark.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        Mark mark02 = Mark.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        Mark mark03 = Mark.builder()
                .rut("13345678-4")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        markRepository.save(mark01);
        markRepository.save(mark02);
        markRepository.save(mark03);
        // when
        Mark found = markRepository.findByRut(mark01.getRut()).get(0);
        List<Mark> founds= markRepository.findByRut(mark01.getRut());
        // then
        Assertions.assertThat(found.getRut()).isEqualTo(mark01.getRut());
        Assertions.assertThat(founds.size()).isEqualTo(2);
    }

    @Test
    public void whenFindByDate_thenReturnMarks(){
        //given
        Mark mark01 = Mark.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        Mark mark02 = Mark.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        Mark mark03 = Mark.builder()
                .rut("13345678-4")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        markRepository.save(mark01);
        markRepository.save(mark02);
        markRepository.save(mark03);
        //when
        List<Mark> founds = markRepository.findByDate(mark01.getDate());
        //then
        Assertions.assertThat(founds.size()).isEqualTo(3);
    }

    @Test
    public void whenDeleteByRut_thenDeleteMark(){
        //given
        Mark mark01 = Mark.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        Mark mark02 = Mark.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        Mark mark03 = Mark.builder()
                .rut("13345678-4")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        markRepository.save(mark01);
        markRepository.save(mark02);
        markRepository.save(mark03);
        //when
        markRepository.deleteByRut(mark01.getRut());
        List<Mark> founds = markRepository.findByDate(mark01.getDate());
        //then
        Assertions.assertThat(founds.size()).isEqualTo(1);
    }

    @Test
    public void whenDeleteByDate_thenDeleteMarks(){
        //given
        Mark mark01 = Mark.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        Mark mark02 = Mark.builder()
                .rut("12345678-9")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        Mark mark03 = Mark.builder()
                .rut("13345678-4")
                .date("2020-01-01")
                .hour("08:00")
                .build();
        markRepository.save(mark01);
        markRepository.save(mark02);
        markRepository.save(mark03);
        //when
        markRepository.deleteByDate(mark01.getDate());
        List<Mark> founds = markRepository.findByDate(mark01.getDate());
        //then
        Assertions.assertThat(founds.size()).isEqualTo(0);
    }

}
