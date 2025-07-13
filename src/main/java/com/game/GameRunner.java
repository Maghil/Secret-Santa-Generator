package com.game;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.game.model.Player;
import com.game.utils.AppProperties;
import com.game.utils.Parser;
import com.game.utils.ParserFactory;
import com.game.utils.SaveGame;
public class GameRunner {

    String player_file_path = AppProperties.get("file.player_list.path");

    String previous_game_path = AppProperties.get("file.previous_game.path");

    String game_save_path = AppProperties.get("file.new_game.path");

    public void run() throws IOException {

        Parser<List<Player>> playerParser = (Parser<List<Player>>) ParserFactory.getParser("player");
        List<Player> players = playerParser.parse(player_file_path);

        Parser<Map<Player, Player>> previousGameParser = (Parser<Map<Player, Player>>) ParserFactory.getParser("previous_game");
        Map<Player, Player> previousPairs = previousGameParser.parse(previous_game_path);

        Map<Player, Player> newPairs = SecretSantaGenerator.generate(players, previousPairs);

        SaveGame.saveSantaPairsCSV(game_save_path, newPairs);
    }
}
