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



    private String name;


    private String surname;


    private String lastname;


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
