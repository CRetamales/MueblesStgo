package cl.msapp.report.service;

import cl.msapp.report.client.EmployeeClient;
import cl.msapp.report.client.HourClient;
import cl.msapp.report.client.JustificationClient;
import cl.msapp.report.client.MarkClient;
import cl.msapp.report.entity.Report;
import cl.msapp.report.model.Employee;
import cl.msapp.report.model.Mark;
import cl.msapp.report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Report> listAllR() {
        return reportRepository.findAll();
    }

    public List<Report> listAllReports() {
        reportRepository.deleteAll();
        //Por cada empleado, se genera un reporte
        //Se obtiene la lista de empleados
        List<Employee> employee = employeeClient.listEmployee().getBody();
        //Se obtiene la marcas de reloj de cada empleado
        List<Mark> mark = markClient.listMark().getBody();

        //Se forma una lista de los años y meses de las marcas de reloj
        String year = "";
        String month = "";
        List<String> yearMonth = new ArrayList<>();
        //formato de fecha: yyyy/mm/dd
        for (Mark m : mark){
            String[] dateParts = m.getDate().split("/");
            year = dateParts[0];
            month = dateParts[1];
            yearMonth.add(year + "-" + month);
        }

        //Se recorre la lista de años y meses para generar un reporte por cada año y mes
        List<Report> report = new ArrayList<>();

        //Se corre los empleados
        for (Employee e : employee){
            //Se crea un reporte por cada empleado
            Report r = new Report();
            r.setRut(e.getRut());
            r.setFullName(e.getNames() + " " + e.getLastNames());
            String category_employee = e.getCategory();
            r.setCategory(category_employee);
            int years_company = e.getYearsCompany();
            r.setYearsCompany(years_company);
            int fixed_salary_employee = 0;
            if (category_employee.equals("A")){
                fixed_salary_employee = 1700000;
            } else if (category_employee.equals("B")){
                fixed_salary_employee = 1200000;
            } else if (category_employee.equals("C")){
                fixed_salary_employee = 800000;
            }
            r.setFixedSalary(fixed_salary_employee);
            int year_bonus_employee = 0;
            //Se obtiene bonificacion por antiguedad al sueldo fijo
            // < 5 años: 0%
            // >= 5 años y < 10 años: 5%
            // >= 10 años y < 15 años: 8%
            // >= 15 años y < 20 años: 11%
            // >= 20 años y < 25 años: 14%
            // >= 25 años: 17%
            if (years_company >= 5 && years_company < 10){
                year_bonus_employee = (int)( (float) fixed_salary_employee * 0.05);
            } else if (years_company >= 10 && years_company < 15){
                year_bonus_employee = (int)( (float) fixed_salary_employee * 0.08);
            } else if (years_company >= 15 && years_company < 20){
                year_bonus_employee = (int)( (float) fixed_salary_employee * 0.11);
            } else if (years_company >= 20 && years_company < 25){
                year_bonus_employee = (int)( (float) fixed_salary_employee * 0.14);
            } else if (years_company >= 25){
                year_bonus_employee = (int)( (float) fixed_salary_employee * 0.17);
            }
            r.setYearBonus(year_bonus_employee);
            int dias_trabajados = 0;
            int descuentos = 0;
            int monto_horas_extras = 0;
            //Se corre los años y meses
            for (String ym : yearMonth){
                //Se obtienen las marcas de reloj del empleado en el año y mes
                List<Mark> markByYearMonthRut = markClient.getMarkByYearMonthRut(ym, e.getRut()).getBody();
                //Se recorre las marcas de reloj del empleado en el año y mes
                //La posicion 0 es la entrada y la posicion 1 es la salida
                for (int i = 0; i < markByYearMonthRut.size(); i++) {
                    if (i % 2 == 0) {
                        //Si la marca se encuentra entre el lunes y el viernes
                        if(markByYearMonthRut.get(i).isRangeLunesViernes()){
                            dias_trabajados++;
                            //Si tiene horas extras
                        }
                        //Si hay descuentos
                        int retraso = markByYearMonthRut.get(i).calcularRetraso();
                        if (retraso > 10 && retraso <= 25){
                            descuentos += 1;
                        } else if ( retraso > 25 && retraso <= 45){
                            descuentos += 3;
                        } else if ( retraso > 45 && retraso <= 70){
                            descuentos += 6;
                        } else if ( retraso > 70){
                            descuentos += 15;
                            //Se verifica si tiene justificacion
                        }
                    }
                }
            }

            //Parte de horas extras
            r.setExtraHoursBonus(monto_horas_extras);
            //Se calcula los montos de los descuentos
            int monto_descuentos = (int)( (float) fixed_salary_employee * ( (float) descuentos / 100));
            r.setDiscounts(monto_descuentos);
            //Se calcula el sueldo bruto
            int gross_salary = fixed_salary_employee + year_bonus_employee + monto_horas_extras - monto_descuentos;
            r.setGrossSalary(gross_salary);

            //Cotizaciones
            int pension_contribution = (int)( (float) gross_salary * 0.10);
            r.setPensionContribution(pension_contribution);
            int health_contribution = (int)( (float) gross_salary * 0.08);
            r.setHealthContribution(health_contribution);
            int finalSalary = gross_salary - pension_contribution - health_contribution;
            r.setFinalSalary(finalSalary);

            reportRepository.save(r);

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
