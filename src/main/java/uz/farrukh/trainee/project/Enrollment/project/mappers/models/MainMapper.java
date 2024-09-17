package uz.farrukh.trainee.project.Enrollment.project.mappers.models;

public interface MainMapper<E, R, T> {
    E requestToEntity(R request);
    T entityToResponse(E entity);
    void toEntity(R request, E foundStudent);
}
