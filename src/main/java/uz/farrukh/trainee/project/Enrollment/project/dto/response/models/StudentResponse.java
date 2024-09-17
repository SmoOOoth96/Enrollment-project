package uz.farrukh.trainee.project.Enrollment.project.dto.response.models;

import lombok.Data;

import java.util.List;

@Data
public class StudentResponse {
    private Long id;
    private String surname;
    private String firstname;
    private String patronymic;
    private int age;
    private List<TeacherResponse> teachers;
}
