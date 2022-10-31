package cl.msapp.report.controller;

import cl.msapp.report.entity.Report;
import cl.msapp.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ResponseEntity<List<Report>> listReport()
    {
        List<Report> reports = reportService.listAllReports();
        if(reports.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReport(@PathVariable("id") Long id)
    {
        Report report = reportService.getReport(id);
        if(report == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(report);
    }

    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report)
    {
        Report reportDB = reportService.createReport(report);
        return ResponseEntity.status(HttpStatus.CREATED).body(reportDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable("id") Long id, @RequestBody Report report)
    {
        report.setId(id);
        Report reportDB = reportService.updateReport(report);
        if(reportDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Report> deleteReport(@PathVariable("id") Long id)
    {
        Report reportDelete = reportService.deleteReport(id);
        if(reportDelete == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportDelete);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<Report>> findByRut(@PathVariable("rut") String rut)
    {
        List<Report> reports = reportService.findByRut(rut);
        if(reports.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Report>> findByCategory(@PathVariable("category") String category)
    {
        List<Report> reports = reportService.findByCategory(category);
        if(reports.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/yearscompany/{yearscompany}")
    public ResponseEntity<List<Report>> findByYearsCompany(@PathVariable("yearscompany") int yearscompany)
    {
        List<Report> reports = reportService.findByYearsCompany(yearscompany);
        if(reports.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/grosssalary/asc")
    public ResponseEntity<List<Report>> findByGrossSalaryAsc()
    {
        List<Report> reports = reportService.listAllReportsOrderByGrossSalaryAsc();
        if(reports.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/grosssalary/desc")
    public ResponseEntity<List<Report>> findByGrossSalaryDesc()
    {
        List<Report> reports = reportService.listAllReportsOrderByGrossSalaryDesc();
        if(reports.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }

    @DeleteMapping("/rut/{rut}")
    public ResponseEntity<Report> deleteByRut(@PathVariable("rut") String rut)
    {
        reportService.deleteByRut(rut);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/category/{category}")
    public ResponseEntity<Report> deleteByCategory(@PathVariable("category") String category)
    {
        reportService.deleteByCategory(category);
        return ResponseEntity.ok().build();
    }


}
