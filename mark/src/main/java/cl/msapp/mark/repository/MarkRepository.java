package cl.msapp.mark.repository;

import cl.msapp.mark.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {

    public List<Mark> findByRut(String rut);
    public List<Mark> findByDate(String date);
    public void deleteByRut(String rut);
    public void deleteByDate(String date);

}
