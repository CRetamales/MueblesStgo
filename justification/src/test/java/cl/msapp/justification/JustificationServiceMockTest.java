package cl.msapp.justification;

import cl.msapp.justification.entity.Justification;
import cl.msapp.justification.repository.JustificationRepository;
import cl.msapp.justification.service.JustificationService;
import cl.msapp.justification.service.JustificationServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class JustificationServiceMockTest {

    @Mock
    private JustificationRepository justificationRepository;

    private JustificationService justificationService;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.openMocks(this);
        justificationService = new JustificationServiceImp(justificationRepository);
        Justification justification01 = Justification.builder()
                .id(1L)
                .rut("12345678-9")
                .category("A")
                .date("01-01-2020")
                .build();

        Mockito.when(justificationRepository.findById(1L))
                .thenReturn(Optional.of(justification01));
        Mockito.when(justificationRepository.save(justification01))
                .thenReturn(justification01);

    }

    @Test
    public void whenValidGetID_ThenReturnJustification()
    {
        Justification found = justificationService.getJustification(1L);
        Assertions.assertThat(found.getRut()).isEqualTo("12345678-9");
    }
}
