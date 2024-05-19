package bip.online.isuus2024.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lessons")
public class LessonsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lesson;
    @ManyToOne
    @JoinColumn(name = "id_special")
    private SpecialsEntity special;
    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    private List<AssessmenEntity> assessmen;
}
