package uz.farrukh.trainee.project.Enrollment.project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import uz.farrukh.trainee.project.Enrollment.project.dto.request.models.SubjectRequest;
import uz.farrukh.trainee.project.Enrollment.project.dto.response.models.SubjectResponse;
import uz.farrukh.trainee.project.Enrollment.project.services.SubjectService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponse> save(@RequestBody SubjectRequest request) {
        return subjectService.save(request);
    }

    @GetMapping("/{id}")
    public SubjectResponse show(@PathVariable("id") long id) {
        return subjectService.getById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@PathVariable Long id, @RequestBody SubjectRequest request) {
        subjectService.update(id, request);
    }

    @GetMapping
    public List<SubjectResponse> findAll() {
        return subjectService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        subjectService.delete(id);
    }
}
