package tv.codely.mooc.students;

import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.students.infrastructure.InMemoryStudentRepository;

public abstract class StudentsModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    protected InMemoryStudentRepository inMemoryStudentRepository = new InMemoryStudentRepository();
}
