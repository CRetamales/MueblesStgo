package cl.msapp.hour.controller;

import cl.msapp.hour.entity.Hour;
import cl.msapp.hour.service.HourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hour")
public class HourController {

    @Autowired
    private HourService hourService;

    @GetMapping
    public ResponseEntity<List<Hour>> listHour()
    {
        List<Hour> hours = hourService.listAllHours();
        if(hours.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(hours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hour> getHour(@PathVariable("id") Long id)
    {
        Hour hour = hourService.getHour(id);
        if(hour == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hour);
    }

    @PostMapping
    public ResponseEntity<Hour> createHour(@RequestBody Hour hour)
    {
        Hour hourDB = hourService.createHour(hour);
        return ResponseEntity.status(HttpStatus.CREATED).body(hourDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hour> updateHour(@PathVariable("id") Long id, @RequestBody Hour hour)
    {
        hour.setId(id);
        Hour hourDB = hourService.updateHour(hour);
        if(hourDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hourDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hour> deleteHour(@PathVariable("id") Long id)
    {
        Hour hourDB = hourService.deleteHour(id);
        if(hourDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hourDB);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<Hour>> findByRut(@PathVariable("rut") String rut)
    {
        List<Hour> hours = hourService.findByRut(rut);
        if(hours.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hours);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Hour>> findByCategory(@PathVariable("category") String category)
    {
        List<Hour> hours = hourService.findByCategory(category);
        if(hours.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hours);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Hour>> findByDate(@PathVariable("date") String date)
    {
        List<Hour> hours = hourService.findByDate(date);
        if(hours.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hours);
    }

    @DeleteMapping("/rut/{rut}")
    public ResponseEntity<Void> deleteByRut(@RequestParam("rut") String rut)
    {
        hourService.deleteByRut(rut);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/category/{category}")
    public ResponseEntity<Void> deleteByCategory(@RequestParam("category") String category)
    {
        hourService.deleteByCategory(category);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/date/{date}")
    public ResponseEntity<Void> deleteByDate(@RequestParam("date") String date)
    {
        hourService.deleteByDate(date);
        return ResponseEntity.ok(null);
    }
}
