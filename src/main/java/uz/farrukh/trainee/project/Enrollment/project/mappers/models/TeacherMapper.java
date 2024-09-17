package uz.farrukh.trainee.project.Enrollment.project.mappers.models;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.farrukh.trainee.project.Enrollment.project.dto.request.models.TeacherRequest;
import uz.farrukh.trainee.project.Enrollment.project.dto.response.models.TeacherResponse;
import uz.farrukh.trainee.project.Enrollment.project.mappers.helpers.TeacherMapperHelper;
import uz.farrukh.trainee.project.Enrollment.project.models.Teacher;

@Mapper(componentModel = "spring", uses = {TeacherMapperHelper.class})
public interface TeacherMapper extends MainMapper<Teacher, TeacherRequest, TeacherResponse>{
    @Override
    @Mapping(source = "subjectId", target = "subject")
    Teacher requestToEntity(TeacherRequest request);

    @Override
    TeacherResponse entityToResponse(Teacher entity);

    @Override
    @Mapping(source = "subjectId", target = "subject")
    void toEntity(TeacherRequest request, @MappingTarget Teacher foundStudent);
}
