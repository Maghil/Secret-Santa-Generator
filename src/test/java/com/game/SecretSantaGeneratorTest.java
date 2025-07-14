package com.game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import com.game.model.Player;

public class SecretSantaGeneratorTest {
    @Test
    public void testGenerateSuccess() {
        List<Player> players = Arrays.asList(
                new Player("Alice", "alice@example.com"),
                new Player("Bob", "bob@example.com"),
                new Player("Carol", "carol@example.com")
        );
        Map<Player, Player> previousPairs = new HashMap<>();
        Map<Player, Player> result = SecretSantaGenerator.generate(players, previousPairs);
        assertEquals(players.size(), result.size());
        for (Map.Entry<Player, Player> entry : result.entrySet()) {
            assertNotEquals(entry.getKey(), entry.getValue());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testGenerateImpossible() {
        List<Player> players = Arrays.asList(
                new Player("Alice", "alice@example.com")
        );
        Map<Player, Player> previousPairs = new HashMap<>();
        SecretSantaGenerator.generate(players, previousPairs);
    }
}
