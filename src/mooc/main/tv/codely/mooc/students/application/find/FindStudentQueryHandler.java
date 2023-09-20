package tv.codely.mooc.students.application.find;

import tv.codely.mooc.students.application.StudentResponse;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.query.QueryHandler;

@Service
public class FindStudentQueryHandler implements QueryHandler<FindStudentQuery, StudentResponse> {
    private final StudentFinder finder;

    public FindStudentQueryHandler(StudentFinder finder) {
        this.finder = finder;
    }

    @Override
    public StudentResponse handle(FindStudentQuery query) {
        return finder.find(new StudentId(query.id()));
    }
}
