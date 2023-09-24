package tv.codely.mooc.students.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.StudentsModuleInfrastructureTestCase;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.mooc.students.domain.StudentMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryStudentRepositoryShould extends StudentsModuleInfrastructureTestCase {

    @Test
     void save_a_student() {
        Student student = StudentMother.random();
        inMemoryStudentRepository.save(student);
    }

    @Test
    void return_an_existing_course() {
        Student student = StudentMother.random();
        inMemoryStudentRepository.save(student);

        assertEquals(Optional.of(student), inMemoryStudentRepository.search(student.id()));
    }

    @Test
    void not_return_a_non_existing_course() {
        assertFalse(inMemoryStudentRepository.search(StudentIdMother.random()).isPresent());
    }
}
