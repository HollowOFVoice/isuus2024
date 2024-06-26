package bip.online.isuus2024.entity;

import jakarta.persistence.*;
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
    private int assessmen;
    @ManyToOne
    @JoinColumn(name = "id_lesson")
    private LessonsEntity lessons;
    @OneToMany(mappedBy = "assessmen", cascade = CascadeType.ALL)
    private List<StudentsEntity> assessmens;
}
