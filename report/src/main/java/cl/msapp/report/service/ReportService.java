package cl.msapp.report.service;

import cl.msapp.report.client.EmployeeClient;
import cl.msapp.report.client.HourClient;
import cl.msapp.report.client.JustificationClient;
import cl.msapp.report.client.MarkClient;
import cl.msapp.report.entity.Report;
import cl.msapp.report.model.Employee;
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

    @Autowired
    EmployeeClient employeeClient;

    @Autowired
    HourClient hourClient;

    @Autowired
    JustificationClient justificationClient;

    @Autowired
    MarkClient markClient;

    public List<Report> listAllReports() {

        //Por cada empleado, se genera un reporte
        //Se obtiene la lista de empleados
        List<Employee> employee = employeeClient.listEmployee().getBody();
        if (employee == null){
            return reportRepository.findAll();
        }
        //Se recorre la lista de empleados
        for (Employee e : employee) {
            //Se crea un reporte
            Report report = new Report();
            //Se obtiene el rut del empleado
            report.setRut(e.getRut());
            //Se obtiene el nombre del empleado
            report.setFullName(e.getNames() + " " + e.getLastNames());
            //Se obtiene la categoria del empleado
            report.setCategory(e.getCategory());
            //Se obtiene los años de antiguedad del empleado
            report.setYearsCompany(2);
            //Se obtiene el sueldo fijo del empleado
            report.setFixedSalary(1000000);
            //Se obtiene el bono anual del empleado
            report.setYearBonus(1000000);
            //Se obtiene el bono por horas extras del empleado
            report.setExtraHoursBonus(1000000);
            //Se obtiene los descuentos del empleado
            report.setDiscounts(1000000);
            //Se obtiene el sueldo bruto del empleado
            report.setGrossSalary(1000000);
            //Se obtiene la cotizacion de pension del empleado
            report.setPensionContribution(1000000);
            //Se obtiene la cotizacion de salud del empleado
            report.setHealthContribution(1000000);
            //Se obtiene el sueldo liquido del empleado
            report.setFinalSalary(1000000);
            //Se guarda el reporte
            reportRepository.save(report);
        }

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
