package bip.online.isuus2024.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "id_assessmen")
    private AssessmenEntity assessmen;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private GroupsEntity groups;

    private String name;
    private String surname;
    private String lastname;
private  int recordBook;

    @Override
    public String toString() {
        return "StudentsEntity{" +
                "id=" + id +
                ", assessmen=" + assessmen +
                ", groups=" + groups +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", recordBook=" + recordBook +
                '}';
    }
}
