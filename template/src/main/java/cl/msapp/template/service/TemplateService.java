package cl.msapp.template.service;

import cl.msapp.template.client.ReportClient;
import cl.msapp.template.model.Report;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class TemplateService {

    @Autowired
    ReportClient reportClient;

    public List<Report> listAllReport(){
        return reportClient.listAllEmployee().getBody();
    }

    public void exportToXls(List<Report> reportList){
        if (reportList == null){
            return;
        }

        File exportFolder = new File("export");
        if (!exportFolder.exists()){
            exportFolder.mkdir();
        }

        File xlsFile = new File(exportFolder, "planilla.xls");
        if(xlsFile.exists()){
            xlsFile.delete();
        }

        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("Planilla");

        org.apache.poi.ss.usermodel.Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("Rut");
        headerRow.createCell(1).setCellValue("Nombre empleado");
        headerRow.createCell(2).setCellValue("Categoria");
        headerRow.createCell(3).setCellValue("Años de servicio empresa");
        headerRow.createCell(4).setCellValue("Sueldo fijo mensual");
        headerRow.createCell(5).setCellValue("Monto Bonificación años servicio");
        headerRow.createCell(6).setCellValue("Monto Pago horas extras");
        headerRow.createCell(7).setCellValue("Monto Descuento");
        headerRow.createCell(8).setCellValue("Sueldo Bruto");
        headerRow.createCell(9).setCellValue("Cotización previsional");
        headerRow.createCell(10).setCellValue("Cotización salud");
        headerRow.createCell(11).setCellValue("Monto suelldo final");

        int rowNum = 1;
        for (Report report : reportList){
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(report.getRut());
            row.createCell(1).setCellValue(report.getFullName());
            row.createCell(2).setCellValue(report.getCategory());
            row.createCell(3).setCellValue(report.getYearsCompany());
            row.createCell(4).setCellValue(report.getFixedSalary());
            row.createCell(5).setCellValue(report.getYearBonus());
            row.createCell(6).setCellValue(report.getExtraHoursBonus());
            row.createCell(7).setCellValue(report.getDiscounts());
            row.createCell(8).setCellValue(report.getGrossSalary());
            row.createCell(9).setCellValue(report.getPensionContribution());
            row.createCell(10).setCellValue(report.getHealthContribution());
            row.createCell(11).setCellValue(report.getFinalSalary());
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(xlsFile);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        }   catch (Exception e) {
            e.printStackTrace();
        }

        try{
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo exportado a: " + xlsFile.getAbsolutePath());
    }
}
