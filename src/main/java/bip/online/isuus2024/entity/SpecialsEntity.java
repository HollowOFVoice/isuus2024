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
@Table(name = "specials")
@Schema(description = "Список специальностей")
public class SpecialsEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я][A-z][a-z]{1,20}")
    @Schema(description = "Название специальности", example = "WebDesign")
    private String special;
    @JsonIgnore
    @OneToMany(mappedBy = "special",cascade = CascadeType.ALL)
    private List<LessonsEntity> students;
}
