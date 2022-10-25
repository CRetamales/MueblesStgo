package cl.msapp.hour.controller;

import cl.msapp.hour.entity.Hour;
import cl.msapp.hour.service.HourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
