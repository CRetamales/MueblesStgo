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
public class JustificationService{

    @Autowired
    private final JustificationRepository justificationRepository;

    public List<Justification> listAllJustifications() {
        return justificationRepository.findAll();
    }

    public Justification getJustification(Long id) {
        return justificationRepository.findById(id).orElse(null);
    }

    public Justification createJustification(Justification justification) {
        justification.setCreatedAt(new Date());
        return justificationRepository.save(justification);
    }

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


    public Justification deleteJustification(Long id) {
        return null;
    }

    public List<Justification> findByRut(String rut) {
        return null;
    }

    public List<Justification> findByDate(String date) {
        return null;
    }

    public List<Justification> findByCategory(String category) {
        return null;
    }

    public List<Justification> deleteByRut(String rut) {
        return null;
    }

    public List<Justification> deleteByDate(String date) {
        return null;
    }

    public List<Justification> deleteByCategory(String category) {
        return null;
    }
}
