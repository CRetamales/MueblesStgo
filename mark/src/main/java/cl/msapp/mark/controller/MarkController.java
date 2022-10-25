package cl.msapp.mark.controller;

import cl.msapp.mark.entity.Mark;
import cl.msapp.mark.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @GetMapping
    public ResponseEntity<List<Mark>> listMark()
    {
        List<Mark> marks = markService.listAllMarks();
        if(marks.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marks);
    }
}
