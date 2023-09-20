package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.StudentId;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.command.CommandHandler;

@Service
public class CreateStudentCommandHandler implements CommandHandler<CreateStudentCommand> {

    private final StudentCreator creator;

    public CreateStudentCommandHandler(StudentCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateStudentCommand command) {
        StudentId id = new StudentId(command.id());

        creator.create(id, command.name(), command.surname(), command.email());
    }
}
