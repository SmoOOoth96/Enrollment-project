package uz.farrukh.trainee.project.Enrollment.project.mappers.helpers;

import org.springframework.stereotype.Component;
import uz.farrukh.trainee.project.Enrollment.project.models.Teacher;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapperHelper {
    public List<Teacher> toTeacherEntityList(List<Long> teacherIds){
        if(teacherIds == null || teacherIds.isEmpty()){
            return null;
        }

        List<Teacher> teachers = new ArrayList<>();
        for(Long teacherId : teacherIds){
            Teacher newTeacher = new Teacher();
            newTeacher.setId(teacherId);
            teachers.add(newTeacher);
        }
        return teachers;
    }
}
