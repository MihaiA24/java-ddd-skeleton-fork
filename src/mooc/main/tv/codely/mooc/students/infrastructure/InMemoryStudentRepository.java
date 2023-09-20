package tv.codely.mooc.students.infrastructure;

import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public final class InMemoryStudentRepository implements StudentRepository {
    private final HashMap<String, Student> studentsList;

    public InMemoryStudentRepository() {
        this.studentsList = new HashMap<>();
    }

    @Override
    public List<Student> searchAll() {
        return new ArrayList<>(studentsList.values());
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return Optional.ofNullable(studentsList.get(id.value()));
    }

    @Override
    public void save(Student student){
        studentsList.put(student.id().value(), student);
    }
}
