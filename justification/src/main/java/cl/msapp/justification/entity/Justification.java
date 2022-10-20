package cl.msapp.justification.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "justification")
@Table(name = "justification", uniqueConstraints = @UniqueConstraint(columnNames = "rut"))
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Justification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rut", nullable = false)
    private String rut;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "created_at", nullable = false)
    private String created_at;
}
