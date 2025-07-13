package com.game.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.game.Player;

public class PlayerListParser implements Parser<List<Player>> {

    @Override
    public List<Player> parse(String filePath) throws IOException {
        List<Player> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",", -1); // -1 to retain empty fields
                if (parts.length < 2) {
                    continue;
                }

                String name = parts[0].trim();
                String email = parts[1].trim();
                players.add(new Player(name, email));

            }
        }
        return players;
    }
}
