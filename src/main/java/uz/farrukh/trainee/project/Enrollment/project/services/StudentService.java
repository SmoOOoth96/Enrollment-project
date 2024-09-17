package uz.farrukh.trainee.project.Enrollment.project.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.farrukh.trainee.project.Enrollment.project.dto.request.models.StudentRequest;
import uz.farrukh.trainee.project.Enrollment.project.dto.response.models.StudentResponse;
import uz.farrukh.trainee.project.Enrollment.project.exceptions.custom.StudentNotFoundException;
import uz.farrukh.trainee.project.Enrollment.project.mappers.models.StudentMapper;
import uz.farrukh.trainee.project.Enrollment.project.models.Student;
import uz.farrukh.trainee.project.Enrollment.project.repositories.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService implements MainService<StudentRequest, StudentResponse> {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Transactional
    @Override
    public ResponseEntity<StudentResponse> save(StudentRequest request) {
        Student newStudent = mapper.requestToEntity(request);
        repository.save(newStudent);
        StudentResponse response = mapper.entityToResponse(newStudent);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional(readOnly = true)
    @Override
    public StudentResponse getById(Long id) {
        Student foundStudent = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        return mapper.entityToResponse(foundStudent);
    }

    @Transactional
    @Override
    public void update(Long id, StudentRequest request) {
        Student foundStudent = repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        mapper.toEntity(request, foundStudent);
        repository.save(foundStudent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentResponse> findAll() {
        return repository.findAll().stream().map(mapper::entityToResponse).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id)));
    }
}
