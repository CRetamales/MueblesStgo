package cl.msapp.employee.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "employee")
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = "rut"))
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private Long id;

    @NotEmpty(message = "El rut no puede ser vacío")
    @Column(name = "rut", nullable = false)
    private String rut;

    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @NotEmpty(message = "El nombre no puede ser vacío")
    @Column(name = "names", length = 50, nullable = false)
    private String names;

    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    @NotEmpty(message = "El apellido no puede ser vacío")
    @Column(name = "last_names", length = 50, nullable = false)
    private String lastNames;

    //
    @Size(min = 10, max = 10, message = "La fecha de nacimiento debe tener 10 caracteres")
    @NotEmpty(message = "La fecha de nacimiento no puede ser vacía")
    @Column(name = "born_date", length = 10, nullable = false)
    private String bornDate;

    @Size(min = 1, max = 1, message = "La categoría debe tener 1 caracter")
    @NotEmpty(message = "La categoría no puede ser vacía")
    @Column(name = "category", length = 1, nullable = false)
    private String category;

    @Size(min = 10, max = 10, message = "La fecha de ingreso debe tener 10 caracteres")
    @NotEmpty(message = "La fecha de ingreso no puede ser vacío")
    @Column(name = "entry_date", length = 10, nullable = false)
    private String entryDate;

}
