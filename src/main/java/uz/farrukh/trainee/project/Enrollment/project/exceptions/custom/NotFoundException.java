package uz.farrukh.trainee.project.Enrollment.project.exceptions.custom;

public abstract class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
