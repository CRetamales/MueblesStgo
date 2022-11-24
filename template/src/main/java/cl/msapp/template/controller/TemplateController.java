package cl.msapp.template.controller;

import cl.msapp.template.model.Report;
import cl.msapp.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @GetMapping
    public ResponseEntity<List<Report>> listAllReport(){
        return ResponseEntity.ok(templateService.listAllReport());
    }
}
