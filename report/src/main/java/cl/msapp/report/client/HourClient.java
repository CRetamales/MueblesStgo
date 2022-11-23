package cl.msapp.report.client;


import cl.msapp.report.model.Hour;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "hour", path = "/hour")
public interface HourClient {

    @GetMapping
    public ResponseEntity<List<Hour>> listHour();

    @GetMapping("/{id}")
    public ResponseEntity<Hour> getHour(@PathVariable("id") Long id);

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<Hour>> findByRut(@PathVariable("rut") String rut);

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Hour>> findByCategory(@PathVariable("category") String category);

}
