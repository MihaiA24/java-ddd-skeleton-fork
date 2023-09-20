package tv.codely.backoffice.courses.application.create;

import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.DomainEventSubscriber;
import tv.codely.shared.domain.course.CourseCreatedDomainEvent;
import tv.codely.shared.infrastructure.EventListener;

@Service
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class CreateBackofficeCourseOnCourseCreated {
    private final BackofficeCourseCreator creator;

    public CreateBackofficeCourseOnCourseCreated(BackofficeCourseCreator creator) {
        this.creator = creator;
    }

    @EventListener
    public void on(CourseCreatedDomainEvent event) {
        creator.create(event.aggregateId(), event.name(), event.duration());
    }
}
