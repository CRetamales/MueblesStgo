package cl.msapp.justification.service;

import cl.msapp.justification.entity.Justification;

import java.util.List;

public interface JustificationService {

    public List<Justification> listAllJustifications();
    public Justification getJustification(Long id);
    public Justification createJustification(Justification justification);
    public Justification updateJustification(Justification justification);
    public Justification deleteJustification(Long id);
    public List<Justification> findByRut(String rut);
    public List<Justification> findByCategory(String category);
    public List<Justification> findByDate(String date);
    public void deleteByRut(String rut);
    public void deleteByDate(String date);
    public void deleteByCategory(String category);

}
