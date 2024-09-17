package uz.farrukh.trainee.project.Enrollment.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.farrukh.trainee.project.Enrollment.project.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
