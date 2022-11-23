package cl.msapp.mark.service;

import cl.msapp.mark.entity.Mark;
import cl.msapp.mark.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class MarkService {

    @Autowired
    private final MarkRepository markRepository;


    public List<Mark> listAllMarks() {
        return markRepository.findAll();
    }

    public Mark getMark(Long id) {
        return markRepository.findById(id).orElse(null);
    }


    public Mark createMark(Mark mark) {

        return markRepository.save(mark);
    }


    public Mark updateMark(Mark mark) {
        Mark markDB = getMark(mark.getId());
        if (markDB == null){
            return null;
        }
        markDB.setRut(mark.getRut());
        markDB.setDate(mark.getDate());
        markDB.setHour(mark.getHour());
        return markRepository.save(markDB);
    }


    public Mark deleteMark(Long id) {
        return null;
    }


    public List<Mark> findByRut(String rut) {
        return null;
    }


    public List<Mark> findByDate(String date) {
        return null;
    }


    public List<Mark> deleteByRut(String rut) {
        return null;
    }

    public List<Mark> deleteByDate(String date) {
        return null;
    }

    //metodo de la clase MarkService para procesar el archivo
    public String uploadFile(MultipartFile file) {
        String message = "";

        //Verifica si la carpeta upload existe, si no existe la crea
        File dir = new File("upload");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        //Verifica si el nombre del archivo es "DATA.txt"
        if (file.getOriginalFilename().equals("DATA.txt")) {
            try {
                //Guarda el archivo en la carpeta upload
                file.transferTo(new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename()));
                message = "Archivo subido correctamente: " + file.getOriginalFilename();
            } catch (Exception e) {
                message = "Fallo al subir el archivo: " + file.getOriginalFilename() + "!";
            }
        } else {
            message = "El nombre del archivo debe ser DATA.txt";
        }

        //Se lee el archivo y se procesa para guardar los datos en la base de datos
        //Se borra lo que se encuentra en la base de datos
        markRepository.deleteAll();
        File fileToRead = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
        if (message.equals("Archivo subido correctamente: DATA.txt")) {
            try{
                Scanner myReader = new Scanner(fileToRead);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] dataSplit = data.split(";");
                    if (dataSplit.length == 3) {

                        Mark mark = new Mark();
                        mark.setRut(dataSplit[2]);
                        mark.setHour(dataSplit[1]);
                        mark.setDate(dataSplit[0]);
                        createMark(mark);
                    }
                    else {
                        message = "El archivo no tiene el formato correcto";
                    }
                }
                myReader.close();
            } catch (Exception e) {
                message = "Fallo al leer el archivo: " + file.getOriginalFilename() + "!";
            }
        }
        return message;
    }




}
