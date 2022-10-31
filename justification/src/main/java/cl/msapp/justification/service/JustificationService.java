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
    public List<Justification> deleteByRut(String rut);
    public List<Justification> deleteByDate(String date);
    public List<Justification> deleteByCategory(String category);

}
