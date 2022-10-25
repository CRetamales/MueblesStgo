package cl.msapp.hour;

import cl.msapp.hour.entity.Hour;
import cl.msapp.hour.repository.HourRepository;
import cl.msapp.hour.service.HourService;
import cl.msapp.hour.service.HourServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class HourServiceMockTest {

    @Mock
    private HourRepository hourRepository;

    private HourService hourService;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.openMocks(this);
        hourService = new HourServiceImp(hourRepository);
        Hour hour01 = Hour.builder()
                .id(1L)
                .rut("12345678-9")
                .category("A")
                .date("01-01-2020")
                .build();

        Mockito.when(hourRepository.findById(1L))
                .thenReturn(Optional.of(hour01));
        Mockito.when(hourRepository.save(hour01))
                .thenReturn(hour01);
    }

    @Test
    public void whenValidGetID_ThenReturnHour()
    {
        Hour found = hourService.getHour(1L);
        Assertions.assertThat(found.getRut()).isEqualTo("12345678-9");
    }
}
