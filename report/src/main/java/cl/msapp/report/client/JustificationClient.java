package cl.msapp.report.client;

import cl.msapp.report.model.Justification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "justification", path = "/justification")
public interface JustificationClient {

    @GetMapping
    public ResponseEntity<List<Justification>> listJustification();

    @GetMapping("/{id}")
    public ResponseEntity<Justification> getJustification(@PathVariable("id") Long id);

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<Justification>> findByRut(@PathVariable("rut") String rut);

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Justification>> findByCategory(@PathVariable("category") String category);



}
