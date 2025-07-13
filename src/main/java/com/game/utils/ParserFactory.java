package com.game.utils;

public class ParserFactory {

    public static Parser<?> getParser(String type) {
        switch (type.toLowerCase()) {
            case "player" -> {
                return new PlayerListParser();
            }
            case "previous_game" -> {
                return new PrevousGameParser();
            }
            default ->
                throw new IllegalArgumentException("Unsupported parser type: " + type);
        }
    }
}
