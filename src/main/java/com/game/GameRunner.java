package com.game;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.game.utils.Parser;
import com.game.utils.ParserFactory;
import com.game.utils.SaveGame;

public class GameRunner {

    String player_file_path = "src/resources/players_list.csv";
    String previous_game_path = "src/resources/previous_game.csv";
    String game_save_path = "src/resources/new_pairs.csv";

    public void run() throws IOException {
        // Step 1: Parse players
        Parser<List<Player>> playerParser = (Parser<List<Player>>) ParserFactory.getParser("player");
        List<Player> players = playerParser.parse(player_file_path);

        // Step 2: Parse previous pairs
        Parser<Map<Player, Player>> previousGameParser = (Parser<Map<Player, Player>>) ParserFactory.getParser("previous_game");
        Map<Player, Player> previousPairs = previousGameParser.parse(previous_game_path);

        // Step 3: Assign new pairs using the algorithm
        Map<Player, Player> newPairs = SecretSantaGenerator.generate(players, previousPairs);

        // Step 4: Save to CSV
        SaveGame.saveSantaPairsCSV(game_save_path, newPairs);
    }
}
