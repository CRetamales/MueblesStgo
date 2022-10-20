package cl.msapp.employee.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "employee")
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = "rut"))
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private Long id;

    @Column(name = "rut", nullable = false)
    private String rut;

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "last_names", nullable = false)
    private String lastNames;

    @Column(name = "born_date", nullable = false)
    private String bornDate;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "entry_date", nullable = false)
    private String entryDate;

}
