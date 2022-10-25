package cl.msapp.justification.service;

import cl.msapp.justification.entity.Justification;
import cl.msapp.justification.repository.JustificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JustificationServiceImp implements JustificationService{

    @Autowired
    private final JustificationRepository justificationRepository;

    @Override
    public List<Justification> listAllJustifications() {
        return justificationRepository.findAll();
    }

    @Override
    public Justification getJustification(Long id) {
        return justificationRepository.findById(id).orElse(null);
    }

    @Override
    public Justification createJustification(Justification justification) {
        justification.setCreatedAt(new Date());
        return justificationRepository.save(justification);
    }

    @Override
    public Justification updateJustification(Justification justification) {
        Justification justificationDB = getJustification(justification.getId());
        if (justificationDB == null){
            return null;
        }
        justificationDB.setRut(justification.getRut());
        justificationDB.setCategory(justification.getCategory());
        justificationDB.setDate(justification.getDate());
        justificationDB.setCreatedAt(justification.getCreatedAt());
        return justificationRepository.save(justificationDB);
    }

    @Override
    public Justification deleteJustification(Long id) {
        return null;
    }

    @Override
    public List<Justification> findByRut(String rut) {
        return null;
    }

    @Override
    public List<Justification> findByDate(String date) {
        return null;
    }

    @Override
    public List<Justification> findByCategory(String category) {
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
