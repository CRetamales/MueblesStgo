package cl.msapp.report.service;

import cl.msapp.report.entity.Report;

import java.util.List;

public interface ReportService {

    public List<Report> listAllReports();
    public Report getReport(Long id);
    public Report createReport(Report report);
    public Report updateReport(Report report);
    public Report deleteReport(Long id);
    public List<Report> findByRut(String rut);
    public List<Report> findByCategory(String category);
    public List<Report> findByYearsCompany(int yearsCompany);
    public List<Report> listAllReportsOrderByGrossSalaryAsc();
    public List<Report> listAllReportsOrderByGrossSalaryDesc();
    public void deleteByRut(String rut);
    public void deleteByCategory(String category);
}
