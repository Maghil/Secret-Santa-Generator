package com.game.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.game.Player;

public class PrevousGameParser implements Parser<Map<Player, Player>> {

    @Override
    public Map<Player, Player> parse(String filePath) throws IOException {
        Map<Player, Player> santa_pairs = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",", -1); // -1 to retain empty fields
                if (parts.length < 4) {
                    continue;
                }

                String santa_name = parts[0].trim();
                String santa_email = parts[1].trim();
                String child_name = parts[2].trim();
                String child_email = parts[3].trim();
                Player santa = new Player(santa_name, santa_email);
                Player child = new Player(child_name, child_email);
                santa_pairs.put(santa, child);

            }
        }
        return santa_pairs;
    }
}
