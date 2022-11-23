package cl.msapp.mark.controller;

import cl.msapp.mark.entity.Mark;
import cl.msapp.mark.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin(origins = "localhost:3000")
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

    //Funcion de metodo post para recibir un archivo txt
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file){

        //Se comprueba que el archivo no este vacio
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo esta vacio");
        }

        // Se obtiene el nombre del archivo
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        //Se comprueba que el archivo sea txt
        if(!fileName.endsWith(".txt")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo no es de tipo txt");
        }

        //Se llama al metodo de la clase MarkService para procesar el archivo
        String response = markService.uploadFile(file);

        //Se retorna el mensaje de respuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


}
