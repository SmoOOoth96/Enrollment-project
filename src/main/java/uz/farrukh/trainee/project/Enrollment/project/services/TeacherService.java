package uz.farrukh.trainee.project.Enrollment.project.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.farrukh.trainee.project.Enrollment.project.dto.request.models.TeacherRequest;
import uz.farrukh.trainee.project.Enrollment.project.dto.response.models.TeacherResponse;
import uz.farrukh.trainee.project.Enrollment.project.exceptions.custom.TeacherNotFoundException;
import uz.farrukh.trainee.project.Enrollment.project.mappers.models.TeacherMapper;
import uz.farrukh.trainee.project.Enrollment.project.models.Teacher;
import uz.farrukh.trainee.project.Enrollment.project.repositories.TeacherRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService implements MainService<TeacherRequest, TeacherResponse> {
    private final TeacherRepository repository;
    private final TeacherMapper mapper;

    @Override
    @Transactional
    public ResponseEntity<TeacherResponse> save(TeacherRequest request) {
        Teacher newTeacher = mapper.requestToEntity(request);
        repository.save(newTeacher);
        TeacherResponse response = mapper.entityToResponse(newTeacher);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    @Transactional(readOnly = true)
    public TeacherResponse getById(Long id) {
        Teacher foundTeacher = repository.findById(id).orElseThrow(
                () -> new TeacherNotFoundException(id)
        );
        return mapper.entityToResponse(foundTeacher);
    }

    @Override
    public void update(Long id, TeacherRequest request) {
        Teacher foundTeacher = repository.findById(id).orElseThrow(
                        () -> new TeacherNotFoundException(id)
                );
        mapper.toEntity(request, foundTeacher);
        repository.save(foundTeacher);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeacherResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(
                () -> new TeacherNotFoundException(id))
        );
    }
}
