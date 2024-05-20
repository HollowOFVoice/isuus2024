package bip.online.isuus2024.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessmens")
public class AssessmenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotNull
    private int assessmen;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_lesson")
    private LessonsEntity lesson;
    @NotNull
    @JsonIgnore
    @OneToMany(mappedBy = "assessmen", cascade = CascadeType.ALL)
    private List<StudentsEntity> students;
}
