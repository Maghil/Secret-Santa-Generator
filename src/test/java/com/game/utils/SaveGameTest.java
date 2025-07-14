package com.game.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.game.model.Player;

public class SaveGameTest {
    @Test
    public void testSave() throws IOException {
        Map<Player, Player> assignments = new HashMap<>();
        Player santa = new Player("Santa", "santa@email.com");
        Player child = new Player("Child", "child@email.com");
        assignments.put(santa, child);
        String filePath = "test_santa_pairs.csv";
        SaveGame.saveSantaPairsCSV(filePath, assignments);
        File file = new File(filePath);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
        file.delete();
    }
}
