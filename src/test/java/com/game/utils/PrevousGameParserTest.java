package com.game.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.game.model.Player;

public class PrevousGameParserTest {
    @Test
    public void testParseFileMissing() throws Exception {
        String filePath = "test_data/test_prev_game.csv";
        File file = new File(filePath);
        if (file.exists()) file.delete();
        PrevousGameParser parser = new PrevousGameParser();
        Map<Player, Player> result = parser.parse(filePath);
        assertTrue(file.exists());
        assertTrue(result.isEmpty());
        file.delete();
    }

    @Test
    public void testParseSuccess() throws Exception {
        String filePath = "test_data/test_prev_game.csv";
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Santa Name,Santa Email,Child Name,Child Email\nAlice,alice@example.com,Bob,bob@example.com\n");
        }
        PrevousGameParser parser = new PrevousGameParser();
        Map<Player, Player> result = parser.parse(filePath);
        assertEquals(1, result.size());
        file.delete();
    }
}
