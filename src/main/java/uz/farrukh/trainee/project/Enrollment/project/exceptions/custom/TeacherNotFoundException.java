package uz.farrukh.trainee.project.Enrollment.project.exceptions.custom;

public class TeacherNotFoundException extends NotFoundException {
    public TeacherNotFoundException(Long id) {
        super("Teacher with id " + id + " not found");
    }
}
