package bip.online.isuus2024.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "lessons")
@Schema(description = "Список изучаемых предметов")
public class LessonsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Изучаемый предмет", example = "Информатика")
    private String lesson;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_special")
    private SpecialsEntity special;
    @JsonIgnore
    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    private List<AssessmenEntity> assessmen;
}
// может просто генерировать среднюю оценку в ццелом у студента, не деля его по специальностям
// и группам
