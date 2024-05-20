package bip.online.isuus2024.entity;

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
public class StudentsEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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
    private String name;

    @NotNull
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    private String surname;

    @NotNull
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    private String lastname;

    @NotNull
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
