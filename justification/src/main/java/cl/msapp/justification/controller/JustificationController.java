package cl.msapp.justification.controller;

import cl.msapp.justification.entity.Justification;
import cl.msapp.justification.service.JustificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/justification")
public class JustificationController {

    @Autowired
    private JustificationService justificationService;

    @GetMapping
    public ResponseEntity<List<Justification>> listJustification()
    {
        List<Justification> justifications = justificationService.listAllJustifications();
        if(justifications.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(justifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Justification> getJustification(@PathVariable("id") Long id)
    {
        Justification justification = justificationService.getJustification(id);
        if(justification == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justification);
    }

    @PostMapping
    public ResponseEntity<Justification> createJustification(@RequestBody Justification justification)
    {
        Justification justificationDB = justificationService.createJustification(justification);
        return ResponseEntity.status(HttpStatus.CREATED).body(justificationDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Justification> updateJustification(@PathVariable("id") Long id, @RequestBody Justification justification)
    {
        justification.setId(id);
        Justification justificationDB = justificationService.updateJustification(justification);
        if(justificationDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justificationDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Justification> deleteJustification(@PathVariable("id") Long id)
    {
        Justification justificationDB = justificationService.deleteJustification(id);
        if(justificationDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justificationDB);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<Justification>> findByRut(@PathVariable("rut") String rut)
    {
        List<Justification> justifications = justificationService.findByRut(rut);
        if(justifications.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justifications);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Justification>> findByCategory(@PathVariable("category") String category)
    {
        List<Justification> justifications = justificationService.findByCategory(category);
        if(justifications.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justifications);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Justification>> findByDate(@PathVariable("date") String date)
    {
        List<Justification> justifications = justificationService.findByDate(date);
        if(justifications.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justifications);
    }

    @DeleteMapping("/rut/{rut}")
    public ResponseEntity<List<Justification>> deleteByRut(@PathVariable("rut") String rut)
    {
        List<Justification> justifications = justificationService.deleteByRut(rut);
        if(justifications.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justifications);
    }

    @DeleteMapping("/category/{category}")
    public ResponseEntity<List<Justification>> deleteByCategory(@PathVariable("category") String category)
    {
        List<Justification> justifications = justificationService.deleteByCategory(category);
        if(justifications.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justifications);
    }

    @DeleteMapping("/date/{date}")
    public ResponseEntity<List<Justification>> deleteByDate(@PathVariable("date") String date)
    {
        List<Justification> justifications = justificationService.deleteByDate(date);
        if(justifications.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(justifications);
    }

}
