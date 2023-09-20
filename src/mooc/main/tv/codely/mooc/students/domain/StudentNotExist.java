package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.DomainError;

public class StudentNotExist extends DomainError {
    public StudentNotExist(StudentId id) {
        super("student_not_exist", String.format("The student <%s> doesn't exist", id.value()));
    }
}
