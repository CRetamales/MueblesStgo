package cl.msapp.mark;

import cl.msapp.mark.entity.Mark;
import cl.msapp.mark.repository.MarkRepository;
import cl.msapp.mark.service.MarkService;
import cl.msapp.mark.service.MarkServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MarkServiceMockTest {

    @Mock
    private MarkRepository markRepository;

    private MarkService markService;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.openMocks(this);
        markService = new MarkServiceImp(markRepository);
        Mark mark01 = Mark.builder()
                .id(1L)
                .rut("12345678-9")
                .date("01-01-2020")
                .hour("08:00")
                .build();

        Mockito.when(markRepository.findById(1L))
                .thenReturn(Optional.of(mark01));
        Mockito.when(markRepository.save(mark01))
                .thenReturn(mark01);

    }

    @Test
    public void whenValidGetID_ThenReturnMark()
    {
        Mark found = markService.getMark(1L);
        Assertions.assertThat(found.getRut()).isEqualTo("12345678-9");
    }
}
