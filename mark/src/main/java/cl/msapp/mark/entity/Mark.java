package cl.msapp.mark.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "mark")
@Table(name = "mark")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rut", nullable = false)
    private String rut;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "hour", nullable = false)
    private String hour;

}
