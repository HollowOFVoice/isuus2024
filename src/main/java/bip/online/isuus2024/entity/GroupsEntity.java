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

@Table(name = "groupss")
@Schema(description = "Список групп")

public class GroupsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotNull
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я][0-9]{1,20}")
    @Schema(description = "Название группы", example = "ИС3")
    private  String groups;
    @JsonIgnore
    @OneToMany (mappedBy = "group",cascade = CascadeType.ALL)
    private List<StudentsEntity> students;


    //не забудь про джэйсон игнор
}
