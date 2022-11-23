package cl.msapp.report.model;


import lombok.Data;

@Data
public class Employee {

    private Long id;

    private String rut;

    private String names;

    private String lastNames;

    private String bornDate;

    private String category;

    private String entryDate;
}
