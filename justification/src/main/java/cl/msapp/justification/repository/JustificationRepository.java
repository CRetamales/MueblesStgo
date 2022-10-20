package cl.msapp.justification.repository;

import cl.msapp.justification.entity.Justification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JustificationRepository extends JpaRepository<Justification, Long> {

    public List<Justification> findByRut(String rut);
    public List<Justification> findByDate(String date);
    public List<Justification> findByCategory(String category);
    public void deleteByRut(String rut);
    public void deleteByDate(String date);
    public void deleteByCategory(String category);

}
