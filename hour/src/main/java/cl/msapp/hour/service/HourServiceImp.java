package cl.msapp.hour.service;

import cl.msapp.hour.entity.Hour;
import cl.msapp.hour.repository.HourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HourServiceImp implements HourService{

    @Autowired
    private final HourRepository hourRepository;

    @Override
    public List<Hour> listAllHours() {
        return hourRepository.findAll();
    }

    @Override
    public Hour getHour(Long id) {
        return hourRepository.findById(id).orElse(null);
    }

    @Override
    public Hour createHour(Hour hour) {
        hour.setCreatedAt(new Date());
        return hourRepository.save(hour);
    }

    @Override
    public Hour updateHour(Hour hour) {
        Hour hourDB = getHour(hour.getId());
        if (hourDB == null){
            return null;
        }
        hourDB.setRut(hour.getRut());
        hourDB.setCategory(hour.getCategory());
        hourDB.setDate(hour.getDate());
        hourDB.setCreatedAt(hour.getCreatedAt());
        return hourRepository.save(hourDB);
    }

    @Override
    public Hour deleteHour(Long id) {
        return null;
    }

    @Override
    public List<Hour> findByRut(String rut) {
        return null;
    }

    @Override
    public List<Hour> findByDate(String date) {
        return null;
    }

    @Override
    public List<Hour> findByCategory(String category) {
        return null;
    }

    public Hour findByRutAndDate(String rut, String date) {
        //El string date debe tener el formato yyyy/MM/dd
        //y viene en formato yyyy-MM-dd
        String[] dateArray = date.split("-");
        String dateFormatted = dateArray[0] + "/" + dateArray[1] + "/" + dateArray[2];
        //Tener todas las horas
        List<Hour> hours = listAllHours();
        //Se recorre la lista de horas
        for (Hour hour : hours) {
            //Se compara si el rut y la fecha son iguales
            if (hour.getRut().equals(rut) && hour.getDate().equals(dateFormatted)) {
                //Se retorna la hora
                return hour;
            }
        }
        //Si no se encuentra la hora, se retorna null
        return null;
    }

    @Override
    public void deleteByRut(String rut) {

    }

    @Override
    public void deleteByDate(String date) {

    }

    @Override
    public void deleteByCategory(String category) {

    }
}
