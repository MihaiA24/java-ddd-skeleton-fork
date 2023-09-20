package tv.codely.mooc.students.application.find;

import tv.codely.shared.domain.bus.query.Query;

public final class FindStudentQuery implements Query {
    private final String id;

    public FindStudentQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
