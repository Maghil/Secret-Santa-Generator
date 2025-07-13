package com.game;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.game.model.Player;
import com.game.utils.Parser;
import com.game.utils.ParserFactory;
import com.game.utils.SaveGame;

public class GameRunner {

    String player_file_path = "src/resources/players_list.csv";
    String previous_game_path = "src/resources/previous_game.csv";
    String game_save_path = "src/resources/new_pairs.csv";

    public void run() throws IOException {

        Parser<List<Player>> playerParser = (Parser<List<Player>>) ParserFactory.getParser("player");
        List<Player> players = playerParser.parse(player_file_path);

        Parser<Map<Player, Player>> previousGameParser = (Parser<Map<Player, Player>>) ParserFactory.getParser("previous_game");
        Map<Player, Player> previousPairs = previousGameParser.parse(previous_game_path);

        Map<Player, Player> newPairs = SecretSantaGenerator.generate(players, previousPairs);

        SaveGame.saveSantaPairsCSV(game_save_path, newPairs);
    }
}
