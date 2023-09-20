package tv.codely.mooc.students.domain;

import tv.codely.mooc.students.application.create.CreateStudentCommand;
import tv.codely.shared.domain.WordMother;

public final class StudentMother {
    public static Student create(StudentId id, String name, String surname, String email) {
        return new Student(id, name, surname, email);
    }

    public static Student fromRequest(CreateStudentCommand command){
        return create(StudentIdMother.create(command.id()), command.name(), command.surname(), command.email());
    }

    public static Student random() {
        return create(StudentIdMother.random(), WordMother.random(), WordMother.random(), WordMother.random());
    }
}
