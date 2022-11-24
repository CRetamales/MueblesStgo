package cl.msapp.template.client;

import cl.msapp.template.model.Report;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "report", path = "/report")
public interface ReportClient {

    @GetMapping("/all")
    public ResponseEntity<List<Report>> listAllEmployee();
}
