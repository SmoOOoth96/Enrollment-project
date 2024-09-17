package uz.farrukh.trainee.project.Enrollment.project.dto.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {
    @Size(min = 2, max = 50, message = "Invalid teacher surname")
    @NotNull(message = "Variable can not be null")
    private String surname;

    @Size(min = 2, max = 50, message = "Invalid teacher firstname")
    @NotNull(message = "Variable can not be null")
    private String firstname;

    @Size(min = 2, max = 50, message = "Invalid teacher patronymic")
    @NotNull(message = "Variable can not be null")
    private String patronymic;

    @Min(value = 21, message = "Age should be more than 21")
    @Max(value = 150, message = "Age should be less than 150")
    @NotNull(message = "Variable can not be null")
    private int age;

    @NotNull(message = "Variable can not be null")
    @Min(value = 1, message = "Invalid subject id")
    private Long subjectId;
}
