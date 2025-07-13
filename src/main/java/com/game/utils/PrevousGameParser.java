package com.game.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.game.model.Player;

public class PrevousGameParser implements Parser<Map<Player, Player>> {

    private static final String DEFAULT_HEADER = "Santa Name,Santa Email,Child Name,Child Email";

    @Override
    public Map<Player, Player> parse(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found. Creating empty file with header: " + filePath);
            file.getParentFile().mkdirs();
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(DEFAULT_HEADER + "\n");
            }
            return new HashMap<>();
        }

        Map<Player, Player> santa_pairs = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",", -1);
                if (parts.length < 4) continue;

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
