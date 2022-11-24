package cl.msapp.report.model;


import lombok.Data;

import java.util.Date;

@Data
public class Justification {

    private Long id;

    private String rut;

    private String date;

    private String category;

    private Date createdAt;

}
