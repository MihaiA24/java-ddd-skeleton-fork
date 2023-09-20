package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

@Service
public class StudentCreator {
    private final StudentRepository repository;

    public StudentCreator(StudentRepository repository) {
        this.repository = repository;
    }

    public void create(StudentId id, String name, String surname, String email ){
        Student student = new Student(id, name, surname, email);
        repository.save(student);
    }
}
