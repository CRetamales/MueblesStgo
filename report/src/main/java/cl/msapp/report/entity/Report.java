package cl.msapp.report.entity;

import cl.msapp.report.model.Employee;
import cl.msapp.report.model.Hour;
import cl.msapp.report.model.Justification;
import cl.msapp.report.model.Mark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "report")
@Table(name = "report")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Transient
    private Employee employee;

    @Transient
    private Hour hour;

    @Transient
    private Justification justification;

    @Transient
    private Mark mark;

    @Column(name = "rut", nullable = false)
    private String rut;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "years_company", nullable = false)
    private int yearsCompany;

    @Column(name = "fixed_salary", nullable = false)
    private int fixedSalary;

    @Column(name = "year_bonus", nullable = false)
    private int yearBonus;

    @Column(name = "extra_hours_bonus", nullable = false)
    private int extraHoursBonus;

    @Column(name = "discounts", nullable = false)
    private int discounts;

    @Column(name = "gross_salary", nullable = false)
    private int grossSalary;

    @Column(name = "pension_contribution", nullable = false)
    private int pensionContribution;

    @Column(name = "health_contribution", nullable = false)
    private int healthContribution;

    @Column(name = "final_salary", nullable = false)
    private int finalSalary;

}
