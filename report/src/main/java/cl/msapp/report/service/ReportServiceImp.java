package cl.msapp.report.service;

import cl.msapp.report.entity.Report;
import cl.msapp.report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImp implements ReportService{

    @Autowired
    private final ReportRepository reportRepository;

    @Override
    public List<Report> listAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public Report getReport(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report updateReport(Report report) {
        Report reportDB = getReport(report.getId());
        if (reportDB == null){
            return null;
        }
        reportDB.setRut(report.getRut());
        reportDB.setFullName(report.getFullName());
        reportDB.setCategory(report.getCategory());
        reportDB.setYearsCompany(report.getYearsCompany());
        reportDB.setFixedSalary(report.getFixedSalary());
        reportDB.setYearBonus(report.getYearBonus());
        reportDB.setExtraHoursBonus(report.getExtraHoursBonus());
        reportDB.setDiscounts(report.getDiscounts());
        reportDB.setGrossSalary(report.getGrossSalary());
        reportDB.setPensionContribution(report.getPensionContribution());
        reportDB.setHealthContribution(report.getHealthContribution());
        reportDB.setFinalSalary(report.getFinalSalary());
        return reportRepository.save(reportDB);
    }

    @Override
    public Report deleteReport(Long id) {
        return null;
    }

    @Override
    public List<Report> findByRut(String rut) {
        return null;
    }

    @Override
    public List<Report> findByCategory(String category) {
        return null;
    }

    @Override
    public List<Report> findByYearsCompany(int yearsCompany) {
        return null;
    }

    @Override
    public List<Report> listAllReportsOrderByGrossSalaryAsc() {
        return null;
    }

    @Override
    public List<Report> listAllReportsOrderByGrossSalaryDesc() {
        return null;
    }

    @Override
    public void deleteByRut(String rut) {

    }

    @Override
    public void deleteByCategory(String category) {

    }
}
