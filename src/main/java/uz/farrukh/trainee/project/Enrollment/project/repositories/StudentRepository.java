package uz.farrukh.trainee.project.Enrollment.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.farrukh.trainee.project.Enrollment.project.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
