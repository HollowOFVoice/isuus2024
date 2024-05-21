package bip.online.isuus2024.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="students")
@Schema(description = "Список студентов")
public class StudentsEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_assessmen")
    private AssessmenEntity assessmen;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_group")
    private GroupsEntity group;

    @NotNull
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Имя Студента", example = "Валерка")
    private String name;

    @NotNull
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Фамилия Студента", example = "Жмышенко")
    private String surname;

    @NotNull
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Отчество студента", example = "Альбертович")
    private String lastname;

    @NotNull
    @Schema(description = "Номер зачетной книжки, записывается лишь цифрами", example = "98647363451")
private  Long recordBook;

//    @Override
//    public String toString() {
//        return "StudentsEntity{" +
//                "id=" + id +
//                ", assessmen=" + assessmen +
//                ", group=" + group +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", recordBook=" + recordBook +
//                '}';
//    }
}
