package uz.farrukh.trainee.project.Enrollment.project.mappers.models;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.farrukh.trainee.project.Enrollment.project.dto.request.models.StudentRequest;
import uz.farrukh.trainee.project.Enrollment.project.dto.response.models.StudentResponse;
import uz.farrukh.trainee.project.Enrollment.project.mappers.helpers.StudentMapperHelper;
import uz.farrukh.trainee.project.Enrollment.project.models.Student;

@Mapper(componentModel = "spring", uses = {StudentMapperHelper.class})
public interface StudentMapper extends MainMapper<Student, StudentRequest, StudentResponse> {
    @Override
    @Mapping(source = "teachersId", target = "teachers")
    Student requestToEntity(StudentRequest request);

    @Override
    StudentResponse entityToResponse(Student entity);

    @Override
    @Mapping(source = "teachersId", target = "teachers")
    void toEntity(StudentRequest request, @MappingTarget Student foundStudent);
}
