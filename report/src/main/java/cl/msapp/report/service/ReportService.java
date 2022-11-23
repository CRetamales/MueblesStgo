package cl.msapp.report.service;

import cl.msapp.report.entity.Report;
import cl.msapp.report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    @Autowired
    private final ReportRepository reportRepository;


    public List<Report> listAllReports() {
        return reportRepository.findAll();
    }


    public Report getReport(Long id) {
        return reportRepository.findById(id).orElse(null);
    }


    public Report createReport(Report report) {
        return reportRepository.save(report);
    }


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


    public Report deleteReport(Long id) {
        return null;
    }


    public List<Report> findByRut(String rut) {
        return null;
    }


    public List<Report> findByCategory(String category) {
        return null;
    }


    public List<Report> findByYearsCompany(int yearsCompany) {
        return null;
    }


    public List<Report> listAllReportsOrderByGrossSalaryAsc() {
        return null;
    }


    public List<Report> listAllReportsOrderByGrossSalaryDesc() {
        return null;
    }


    public void deleteByRut(String rut) {

    }
    
    public void deleteByCategory(String category) {

    }
}
