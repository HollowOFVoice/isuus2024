package bip.online.isuus2024.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Список оценок по изучаемым предметам")
public class AssessmenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    @Schema(description = "оценка студента", example = "5")
    private int assessmen;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_lesson")
    private LessonsEntity lesson;


    @JsonIgnore
    @OneToMany(mappedBy = "assessmen", cascade = CascadeType.ALL)
    private List<StudentsEntity> students;
}
