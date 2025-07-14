package com.game.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.game.model.Player;

public class PlayerListParserTest {
    @Test
    public void testParse() throws Exception {
        String filePath = "test_players.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Name,Email\nAlice,alice@example.com\nBob,bob@example.com\n");
        }
        PlayerListParser parser = new PlayerListParser();
        List<Player> players = parser.parse(filePath);
        assertEquals(2, players.size());
        assertEquals("Alice", players.get(0).getName());
        assertEquals("bob@example.com", players.get(1).getEmail());
        new File(filePath).delete();
    }
}
