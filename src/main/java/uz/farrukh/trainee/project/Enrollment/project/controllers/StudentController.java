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
import uz.farrukh.trainee.project.Enrollment.project.dto.request.models.StudentRequest;
import uz.farrukh.trainee.project.Enrollment.project.dto.response.models.StudentResponse;
import uz.farrukh.trainee.project.Enrollment.project.services.StudentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponse> save(@RequestBody StudentRequest request){
        return studentService.save(request);
    }

    @GetMapping("/{id}")
    public StudentResponse show(@PathVariable Long id){
        return studentService.getById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@PathVariable Long id, @RequestBody StudentRequest request){
        studentService.update(id, request);
    }

    @GetMapping
    public List<StudentResponse> findAll(){
        return studentService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        studentService.delete(id);
    }
}
