package uz.farrukh.trainee.project.Enrollment.project.dto.response.models;

import lombok.Data;

@Data
public class TeacherResponse {
    private Long id;
    private String surname;
    private String firstname;
    private String patronymic;
    private int age;
    private SubjectResponse subject;
}
