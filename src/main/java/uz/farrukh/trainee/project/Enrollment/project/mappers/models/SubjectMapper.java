package uz.farrukh.trainee.project.Enrollment.project.mappers.models;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.farrukh.trainee.project.Enrollment.project.dto.request.models.SubjectRequest;
import uz.farrukh.trainee.project.Enrollment.project.dto.response.models.SubjectResponse;
import uz.farrukh.trainee.project.Enrollment.project.models.Subject;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends MainMapper<Subject, SubjectRequest, SubjectResponse>{
    @Override
    Subject requestToEntity(SubjectRequest request);

    @Override
    SubjectResponse entityToResponse(Subject entity);

    @Override
    void toEntity(SubjectRequest request, @MappingTarget Subject foundStudent);
}
