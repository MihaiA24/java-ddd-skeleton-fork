package tv.codely.mooc.students.domain;

import tv.codely.mooc.students.application.create.CreateStudentCommand;
import tv.codely.shared.domain.WordMother;

public class CreateStudentCommandMonther {
    public static CreateStudentCommand create(StudentId id, String name, String surname, String email){
        return new CreateStudentCommand(id.value(), name, surname, email);
    }

    public static CreateStudentCommand random() {
        return create(StudentIdMother.random(), WordMother.random(), WordMother.random(), WordMother.random());
    }
}
