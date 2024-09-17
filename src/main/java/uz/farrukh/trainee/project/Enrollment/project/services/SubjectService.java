package uz.farrukh.trainee.project.Enrollment.project.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.farrukh.trainee.project.Enrollment.project.dto.request.models.SubjectRequest;
import uz.farrukh.trainee.project.Enrollment.project.dto.response.models.SubjectResponse;
import uz.farrukh.trainee.project.Enrollment.project.exceptions.custom.SubjectNotFoundException;
import uz.farrukh.trainee.project.Enrollment.project.mappers.models.SubjectMapper;
import uz.farrukh.trainee.project.Enrollment.project.models.Subject;
import uz.farrukh.trainee.project.Enrollment.project.repositories.SubjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService implements MainService<SubjectRequest, SubjectResponse> {
    private final SubjectRepository repository;
    private final SubjectMapper mapper;

    @Transactional
    @Override
    public ResponseEntity<SubjectResponse> save(SubjectRequest request) {
        Subject newSubject = mapper.requestToEntity(request);
        repository.save(newSubject);
        SubjectResponse response = mapper.entityToResponse(newSubject);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional(readOnly = true)
    @Override
    public SubjectResponse getById(Long id) {
        return mapper.entityToResponse(repository.findById(id).orElseThrow(
                () -> new SubjectNotFoundException(id))
        );
    }

    @Transactional
    @Override
    public void update(Long id, SubjectRequest request) {
        Subject foundSubject = repository.findById(id).orElseThrow(
                () -> new SubjectNotFoundException(id)
        );
        mapper.toEntity(request, foundSubject);
        repository.save(foundSubject);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubjectResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(
                () -> new SubjectNotFoundException(id))
        );
    }
}
