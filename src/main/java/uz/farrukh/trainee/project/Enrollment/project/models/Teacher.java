package uz.farrukh.trainee.project.Enrollment.project.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Teacher")
public class Teacher {
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

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
}