package cl.msapp.hour.repository;

import cl.msapp.hour.entity.Hour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HourRepository extends JpaRepository<Hour, Long> {

    public List<Hour> findByRut(String rut);
    public List<Hour> findByDate(String date);
    public List<Hour> findByCategory(String category);
    public void deleteByRut(String rut);
    public void deleteByDate(String date);
    public void deleteByCategory(String category);

}
