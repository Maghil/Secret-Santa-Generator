package com.game.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.game.Player;

public class ExcelWrite {

    public static void writeSantaPairs(String filePath, Map<Player, Player> assignments) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Santa Name,Santa Email,Child Name,Child Email\n");

            for (Map.Entry<Player, Player> entry : assignments.entrySet()) {
                Player santa = entry.getKey();
                Player child = entry.getValue();

                writer.write(formatCsv(santa.getName()) + ","
                        + formatCsv(santa.getEmail()) + ","
                        + formatCsv(child.getName()) + ","
                        + formatCsv(child.getEmail()) + "\n");
            }
        }
    }

    private static String formatCsv(String value) {
        if (value.contains(",") || value.contains("\"")) {
            value = value.replace("\"", "\"\"");
            return "\"" + value + "\"";
        }
        return value;
    }
}
