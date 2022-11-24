package cl.msapp.hour.service;

import cl.msapp.hour.entity.Hour;

import java.util.List;

public interface HourService {

    public List<Hour> listAllHours();
    public Hour getHour(Long id);
    public Hour createHour(Hour hour);
    public Hour updateHour(Hour hour);
    public Hour deleteHour(Long id);
    public List<Hour> findByRut(String rut);
    public List<Hour> findByCategory(String category);
    public List<Hour> findByDate(String date);
    public void deleteByRut(String rut);
    public void deleteByCategory(String category);
    public void deleteByDate(String date);
    public Hour findByRutAndDate(String rut, String date);
}
