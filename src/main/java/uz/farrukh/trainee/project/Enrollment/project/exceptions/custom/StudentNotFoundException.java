package uz.farrukh.trainee.project.Enrollment.project.exceptions.custom;

public class StudentNotFoundException extends NotFoundException {
    public StudentNotFoundException(Long id) {
        super("Student with id: " + id + " not found");
    }
}