package uz.farrukh.trainee.project.Enrollment.project.exceptions.custom;

public class SubjectNotFoundException extends NotFoundException{
    public SubjectNotFoundException(Long id){
        super("Subject with id " + id + " not found");
    }
}
