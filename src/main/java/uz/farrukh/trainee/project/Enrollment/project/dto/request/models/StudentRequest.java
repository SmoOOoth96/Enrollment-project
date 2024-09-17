package uz.farrukh.trainee.project.Enrollment.project.dto.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    @Size(min = 2, max = 50, message = "Invalid student surname")
    @NotNull(message = "Variable can not be null")
    private String surname;

    @Size(min = 2, max = 50, message = "Invalid student firstname")
    @NotNull(message = "Variable can not be null")
    private String firstname;

    @Size(min = 2, max = 50, message = "Invalid student patronymic")
    @NotNull(message = "Variable can not be null")
    private String patronymic;

    @Min(value = 10, message = "Age should be more than 10")
    @Max(value = 150, message = "Age should be less than 150")
    @NotNull(message = "Variable can not be null")
    private int age;

    @NotNull(message = "Variable can not be null")
    private List<Long> teachersId;
}
