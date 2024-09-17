package uz.farrukh.trainee.project.Enrollment.project.dto.request.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {
    @Size(min = 2, max = 50, message = "Invalid subject name")
    @NotNull(message = "Variable can not be null")
    private String name;
}
