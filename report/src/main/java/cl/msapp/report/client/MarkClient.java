package cl.msapp.report.client;


import cl.msapp.report.model.Mark;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "mark", path = "/mark")
public interface MarkClient {

    @GetMapping
    public ResponseEntity<List<Mark>> listMark();

    @GetMapping("/{id}")
    public ResponseEntity<Mark> getMark(@PathVariable("id") Long id);

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<Mark>> findByRut(@PathVariable("rut") String rut);

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Mark>> findByDate(@PathVariable("date") String date);

    @GetMapping("/yearMonthRut/{yearMonth}/{rut}")
    public ResponseEntity<List<Mark>> getMarkByYearMonthRut(@PathVariable("yearMonth") String yearMonth, @PathVariable("rut") String rut);


}
