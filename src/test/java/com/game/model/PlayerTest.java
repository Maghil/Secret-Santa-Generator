package com.game.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void testGet() {
        Player player = new Player("Alice", "alice@example.com");
        assertEquals("Alice", player.getName());
        assertEquals("alice@example.com", player.getEmail());
    }
}
