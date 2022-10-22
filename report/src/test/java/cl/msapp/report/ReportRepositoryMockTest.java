package cl.msapp.report;

import cl.msapp.report.entity.Report;
import cl.msapp.report.repository.ReportRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReportRepositoryMockTest {

    @Autowired
    private ReportRepository reportRepository;

    @Test
    public void whenFindByRut_thenReturnReport() {
        // given
        Report report01 = Report.builder()
                .rut("12345678-9")
                .fullName("Juan Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report02 = Report.builder()
                .rut("12345678-1")
                .fullName("Antonio Perez")
                .category("C")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        reportRepository.save(report01);
        reportRepository.save(report02);
        // when
        Report found = reportRepository.findByRut(report01.getRut()).get(0);
        List<Report> founds = reportRepository.findByRut(report01.getRut());
        // then
        Assertions.assertThat(found.getRut()).isEqualTo(report01.getRut());
        Assertions.assertThat(founds.size()).isEqualTo(1);
    }

    @Test
    public void whenFindByCategory_thenReturnReport() {
        // given
        Report report01 = Report.builder()
                .rut("12345678-9")
                .fullName("Juan Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report02 = Report.builder()
                .rut("12345678-1")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        reportRepository.save(report01);
        reportRepository.save(report02);
        // when
        List<Report> founds = reportRepository.findByCategory(report01.getCategory());
        // then
        Assertions.assertThat(founds.size()).isEqualTo(2);
    }

    @Test
    public void whenFindByYears_company_thenReturnReport() {
        // given
        Report report01 = Report.builder()
                .rut("12345678-9")
                .fullName("Juan Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report02 = Report.builder()
                .rut("12345678-1")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(2)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report03 = Report.builder()
                .rut("12345678-2")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        // when
        reportRepository.save(report01);
        reportRepository.save(report02);
        reportRepository.save(report03);
        // then
        List<Report> founds = reportRepository.findByYearsCompany(report01.getYearsCompany());
        Assertions.assertThat(founds.size()).isEqualTo(2);
    }

    @Test
    public void whenGetAllGross_salaryAsc_thenReturnReports() {
        // given
        Report report01 = Report.builder()
                .rut("12345678-9")
                .fullName("Juan Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report02 = Report.builder()
                .rut("12345678-1")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(2)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(3000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report03 = Report.builder()
                .rut("12345678-2")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(500000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        reportRepository.save(report01);
        reportRepository.save(report02);
        reportRepository.save(report03);
        // when
        List<Report> founds = reportRepository.getAllGrossSalaryAsc();
        // then
        Assertions.assertThat(founds.size()).isEqualTo(3);
        Assertions.assertThat(founds.get(0).getGrossSalary()).isEqualTo(report03.getGrossSalary());
    }

    @Test
    public void whenGetAllByGross_salaryDesc_thenReturnReport() {
        // given
        Report report01 = Report.builder()
                .rut("12345678-9")
                .fullName("Juan Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report02 = Report.builder()
                .rut("12345678-1")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(2)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(3000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report03 = Report.builder()
                .rut("12345678-2")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(500000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        reportRepository.save(report01);
        reportRepository.save(report02);
        reportRepository.save(report03);
        // when
        List<Report> founds = reportRepository.getAllGrossSalaryDesc();
        // then
        Assertions.assertThat(founds.size()).isEqualTo(3);
        Assertions.assertThat(founds.get(0).getGrossSalary()).isEqualTo(report02.getGrossSalary());
    }

    @Test
    public void whenDeleteByRut_thenReturnReport() {
        // given
        Report report01 = Report.builder()
                .rut("12345678-9")
                .fullName("Juan Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report02 = Report.builder()
                .rut("12345678-1")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(2)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(3000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report03 = Report.builder()
                .rut("12345678-2")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(500000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        reportRepository.save(report01);
        reportRepository.save(report02);
        reportRepository.save(report03);
        // when
        reportRepository.deleteByRut(report01.getRut());
        // then
        Assertions.assertThat(reportRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    public void whenDeleteByCategory_thenReturnReport() {
        // given
        Report report01 = Report.builder()
                .rut("12345678-9")
                .fullName("Juan Perez")
                .category("A")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(1000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report02 = Report.builder()
                .rut("12345678-1")
                .fullName("Antonio Perez")
                .category("A")
                .yearsCompany(2)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(3000000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        Report report03 = Report.builder()
                .rut("12345678-2")
                .fullName("Antonio Perez")
                .category("B")
                .yearsCompany(1)
                .fixedSalary(100000)
                .yearBonus(10000)
                .extraHoursBonus(1000)
                .discounts(100)
                .grossSalary(500000)
                .pensionContribution(10000)
                .healthContribution(10000)
                .finalSalary(1000000)
                .build();
        reportRepository.save(report01);
        reportRepository.save(report02);
        reportRepository.save(report03);
        // when
        reportRepository.deleteByCategory(report01.getCategory());
        // then
        Assertions.assertThat(reportRepository.findAll().size()).isEqualTo(1);
    }

}
