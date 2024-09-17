package uz.farrukh.trainee.project.Enrollment.project.services;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MainService<R, T> {
    ResponseEntity<T> save(R r);

    T getById(Long id);

    void update(Long id, R r);

    List<T> findAll();

    void delete(Long id);
}
