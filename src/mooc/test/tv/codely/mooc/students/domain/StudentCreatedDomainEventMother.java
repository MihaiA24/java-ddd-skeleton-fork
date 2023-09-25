package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.WordMother;
import tv.codely.shared.domain.student.StudentCreatedDomainEvent;

public final class StudentCreatedDomainEventMother {
    public static StudentCreatedDomainEvent create(StudentId id, String name, String surname, String email) {
        return new StudentCreatedDomainEvent(id.value(), name, surname, email);
    }

    public static StudentCreatedDomainEvent fromCourse(Student student) {
        return create(student.id(), student.name(), student.surname(), student.email());
    }

    public static StudentCreatedDomainEvent random() {
        return create(StudentIdMother.random(), WordMother.random(), WordMother.random(), WordMother.random());
    }
}
