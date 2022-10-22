package cl.msapp.report.repository;

import cl.msapp.report.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    public List<Report> findByRut(String rut);
    public List<Report> findByCategory(String category);
    public List<Report> findByYearsCompany(int years_company);
    @Query(value = "SELECT * FROM report ORDER BY gross_salary ASC", nativeQuery = true)
    public List<Report> getAllGrossSalaryAsc();
    @Query(value = "SELECT * FROM report ORDER BY gross_salary DESC", nativeQuery = true)
    public List<Report> getAllGrossSalaryDesc();
    public void deleteByRut(String rut);
    public void deleteByCategory(String category);
}
