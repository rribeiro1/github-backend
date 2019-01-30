package com.vanhack.github.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {

    @Test
    @DisplayName("Should Validated the Actor Domain")
    public void shouldReturnFields() {
        Actor actorA = new Actor("rribeiro1", "Rafael", "http://avatar.com/rribeiro1");

        Actor actorB = new Actor();
        actorB.setId("jussara12");
        actorB.setName("Jussara Cardoso");

        assertNotNull(actorA);
        assertNotNull(actorB);
        assertEquals("rribeiro1", actorA.getId());
        assertEquals("Rafael", actorA.getName());
    }
}
