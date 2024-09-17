package uz.farrukh.trainee.project.Enrollment.project.mappers.helpers;

import org.springframework.stereotype.Component;
import uz.farrukh.trainee.project.Enrollment.project.models.Subject;

@Component
public class TeacherMapperHelper {
    public Subject toSubjectEntity(Long id) {
        if(id == null) return null;

        Subject subject = new Subject();
        subject.setId(id);
        return subject;
    }
}
