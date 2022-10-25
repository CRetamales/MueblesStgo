package cl.msapp.mark.service;

import cl.msapp.mark.entity.Mark;
import cl.msapp.mark.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkServiceImp implements MarkService{

    @Autowired
    private final MarkRepository markRepository;

    @Override
    public List<Mark> listAllMarks() {
        return markRepository.findAll();
    }

    @Override
    public Mark getMark(Long id) {
        return markRepository.findById(id).orElse(null);
    }

    @Override
    public Mark createMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
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

    @Override
    public Mark deleteMark(Long id) {
        return null;
    }

    @Override
    public List<Mark> findByRut(String rut) {
        return null;
    }

    @Override
    public List<Mark> findByDate(String date) {
        return null;
    }

    @Override
    public void deleteByRut(String rut) {

    }

    @Override
    public void deleteByDate(String date) {

    }
}
