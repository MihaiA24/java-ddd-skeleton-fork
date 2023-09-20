package tv.codely.apps.mooc.backend.controller.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.courses.domain.CourseNotExist;
import tv.codely.mooc.students.application.StudentResponse;
import tv.codely.mooc.students.application.StudentsResponse;
import tv.codely.mooc.students.application.find.FindStudentQuery;
import tv.codely.mooc.students.application.search_all.SearchAllStudentsQuery;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.bus.query.QueryHandlerExecutionError;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class StudentGetController extends ApiController {
    public StudentGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        StudentResponse student = ask(new FindStudentQuery(id));

        HashMap<String,Serializable> hashMap = new HashMap<>();
        hashMap.put("id", student.id());
        hashMap.put("name", student.name());
        hashMap.put("surname", student.surname());
        hashMap.put("email", student.surname());

        return ResponseEntity.ok().body(hashMap);
    }

    @GetMapping("/students/all")
    public List<HashMap<String, Serializable>> index() throws QueryHandlerExecutionError {
        StudentsResponse studentsResponse = ask(new SearchAllStudentsQuery());

        return studentsResponse.students().stream().map(student -> {
            HashMap<String, Serializable> studentMap = new HashMap<>();
            studentMap.put("id", student.id());
            studentMap.put("name", student.name());
            studentMap.put("surname", student.surname());
            studentMap.put("email", student.email());
            return studentMap;
        }).collect(Collectors.toList());
    }

        @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
            HashMap<Class<? extends DomainError>,HttpStatus> hashMap = new HashMap<>();
            hashMap.put(CourseNotExist.class, HttpStatus.NOT_FOUND);
            return hashMap;
    }
}
