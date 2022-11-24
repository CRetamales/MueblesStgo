package cl.msapp.template.model;

import lombok.Data;

@Data
public class Report {

    private Long id;

    private String rut;

    private String fullName;

    private String category;

    private int yearsCompany;

    private int fixedSalary;

    private int yearBonus;

    private int extraHoursBonus;

    private int discounts;

    private int grossSalary;

    private int pensionContribution;

    private int healthContribution;

    private int finalSalary;
}
