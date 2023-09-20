package tv.codely.apps.mooc.backend.controller.greeter;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;

final class GreeterGetControllerShould extends MoocApplicationTestCase {
    @Test
    void shouldCheckAGreeterResponse() throws Exception {
        assertResponse("/greeter?name=Mihai", 200, "{'message': 'Hello Mihai'}");
    }
}
