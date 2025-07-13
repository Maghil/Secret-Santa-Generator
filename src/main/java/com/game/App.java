package com.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.utils.ExcelWrite;
import com.game.utils.Parser;
import com.game.utils.ParserFactory;

public class App {

    public static void main(String[] args) throws IOException {
        List<Player> players = new ArrayList<>();
        Map<Player, Player> previous_pairs = new HashMap<>();
        Map<Player, Player> new_pairs = new HashMap<>();

        Parser<List<Player>> player_parser = (Parser<List<Player>>) ParserFactory.getParser("player");
        Parser<Map<Player, Player>> game_parser = (Parser<Map<Player, Player>>) ParserFactory.getParser("previous_game");

        players = player_parser.parse("src\\resources\\players_list.csv");
        previous_pairs = game_parser.parse("src\\resources\\previous_game.csv");
        new_pairs = SecretSanta.assignSecretSantas(players, previous_pairs);
        ExcelWrite.writeSantaPairs("src\\resources\\new_pairs.csv", new_pairs);
    }
}
