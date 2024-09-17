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
import uz.farrukh.trainee.project.Enrollment.project.dto.request.models.TeacherRequest;
import uz.farrukh.trainee.project.Enrollment.project.dto.response.models.TeacherResponse;
import uz.farrukh.trainee.project.Enrollment.project.services.TeacherService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherResponse> save(@RequestBody TeacherRequest request){
        return teacherService.save(request);
    }

    @GetMapping("/{id}")
    public TeacherResponse show(@PathVariable("id") long id){
        return teacherService.getById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@PathVariable Long id, @RequestBody TeacherRequest request){
        teacherService.update(id, request);
    }

    @GetMapping
    public List<TeacherResponse> findAll(){
        return teacherService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        teacherService.delete(id);
    }
}
