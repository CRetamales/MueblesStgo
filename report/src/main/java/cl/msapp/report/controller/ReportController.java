package cl.msapp.report.controller;

import cl.msapp.report.entity.Report;
import cl.msapp.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
