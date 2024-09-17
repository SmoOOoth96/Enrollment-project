package uz.farrukh.trainee.project.Enrollment.project.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "age", nullable = false)
    private int age;

    @ManyToMany
    @JoinColumn(name = "teachers")
    private List<Teacher> teachers;
}
