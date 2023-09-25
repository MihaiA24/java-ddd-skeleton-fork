package tv.codely.shared.domain.student;

import tv.codely.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class StudentCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final String surname;
    private final String email;

    public StudentCreatedDomainEvent() {
        super(null);

        this.name     = null;
        this.surname = null;
        this.email = null;
    }

    public StudentCreatedDomainEvent(String aggregateId, String name, String surname, String email) {
        super(aggregateId);

        this.name     = name;
        this.surname = surname;
        this.email = email;
    }

    public StudentCreatedDomainEvent(
        String aggregateId,
        String eventId,
        String occurredOn,
        String name,
        String surname,
        String email
    ) {
        super(aggregateId, eventId, occurredOn);

        this.name     = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String eventName() {
        return "student.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> hashMap = new HashMap<>();
        hashMap.put("name", name);
        hashMap.put("surname", surname);
        hashMap.put("email", email);
        return hashMap;
    }

    @Override
    public StudentCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new StudentCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("name"),
            (String) body.get("surnmae"),
            (String) body.get("email")
        );
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

        StudentCreatedDomainEvent that = (StudentCreatedDomainEvent) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
		return Objects.equals(email, that.email);
	}

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email);
    }
}
