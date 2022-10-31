package cl.msapp.mark.controller;

import cl.msapp.mark.entity.Mark;
import cl.msapp.mark.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Mark> getMark(@PathVariable("id") Long id)
    {
        Mark mark = markService.getMark(id);
        if(mark == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mark);
    }

    @PostMapping
    public ResponseEntity<Mark> createMark(@RequestBody Mark mark)
    {
        Mark markDB = markService.createMark(mark);
        return ResponseEntity.status(HttpStatus.CREATED).body(markDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mark> updateMark(@PathVariable("id") Long id, @RequestBody Mark mark)
    {
        mark.setId(id);
        Mark markDB = markService.updateMark(mark);
        if(markDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(markDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mark> deleteMark(@PathVariable("id") Long id)
    {
        Mark markDB = markService.deleteMark(id);
        if(markDB == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(markDB);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<List<Mark>> findByRut(@PathVariable("rut") String rut)
    {
        List<Mark> marks = markService.findByRut(rut);
        if(marks.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marks);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Mark>> findByDate(@PathVariable("date") String date)
    {
        List<Mark> marks = markService.findByDate(date);
        if(marks.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marks);
    }

    @DeleteMapping("/rut/{rut}")
    public ResponseEntity<List<Mark>> deleteByRut(@PathVariable("rut") String rut)
    {
        List<Mark> marks = markService.deleteByRut(rut);
        if(marks.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marks);
    }

    @DeleteMapping("/date/{date}")
    public ResponseEntity<List<Mark>> deleteByDate(@PathVariable("date") String date)
    {
        List<Mark> marks = markService.deleteByDate(date);
        if(marks.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marks);
    }

}
