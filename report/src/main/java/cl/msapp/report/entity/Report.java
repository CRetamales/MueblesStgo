package cl.msapp.report.entity;

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

    @Column(name = "rut", nullable = false)
    private String rut;

    @Column(name = "full_name", nullable = false)
    private String full_name;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "years_company", nullable = false)
    private int years_company;

    @Column(name = "fixed_salary", nullable = false)
    private int fixed_salary;

    @Column(name = "year_bonus", nullable = false)
    private int year_bonus;

    @Column(name = "extra_hours_bonus", nullable = false)
    private int extra_hours_bonus;

    @Column(name = "discounts", nullable = false)
    private int discounts;

    @Column(name = "gross_salary", nullable = false)
    private int gross_salary;

    @Column(name = "pension_contribution", nullable = false)
    private int pension_contribution;

    @Column(name = "health_contribution", nullable = false)
    private int health_contribution;

    @Column(name = "final_salary", nullable = false)
    private int final_salary;

}
