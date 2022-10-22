package cl.msapp.mark.service;

import cl.msapp.mark.entity.Mark;

import java.util.List;

public interface MarkService {

    public List<Mark> listAllMarks();
    public Mark getMark(Long id);
    public Mark createMark(Mark mark);
    public Mark updateMark(Mark mark);
    public Mark deleteMark(Long id);
    public List<Mark> findByRut(String rut);
    public List<Mark> findByDate(String date);
    public void deleteByRut(String rut);
    public void deleteByDate(String date);

}
