package tv.codely.mooc.students.application.find;

import tv.codely.mooc.students.application.StudentResponse;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentNotExist;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

@Service
public class StudentFinder {
    private final StudentRepository repository;

    public StudentFinder(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentResponse find(StudentId id) {
        return repository.search(id)
            .map(StudentResponse::fromAggregate)
            .orElseThrow(() -> new StudentNotExist(id));
    }
}
