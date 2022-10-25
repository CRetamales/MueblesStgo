package cl.msapp.justification.controller;

import cl.msapp.justification.entity.Justification;
import cl.msapp.justification.service.JustificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
