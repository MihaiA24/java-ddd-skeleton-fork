package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.student.StudentCreatedDomainEvent;

import java.util.Objects;

public final class Student extends AggregateRoot {
    private final StudentId id;
    private final String    name;
    private final String    surname;
    private final String    email;

    public Student(StudentId id, String name, String surname, String email) {
        this.id      = id;
        this.name    = name;
        this.surname = surname;
        this.email   = email;
    }

    public static Student create(StudentId id, String name, String surname, String email){
        Student student = new Student(id, name, surname, email);

        student.record(new StudentCreatedDomainEvent(id.value(), name, surname, email));

        return student;
    }

    public StudentId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!Objects.equals(id, student.id)) return false;
        if (!Objects.equals(name, student.name)) return false;
        if (!Objects.equals(surname, student.surname)) return false;
		return Objects.equals(email, student.email);
	}

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email);
    }
}
