package com.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.game.model.Player;
import com.game.utils.AppProperties;

public class SecretSantaGenerator {

    public static Map<Player, Player> generate(List<Player> players, Map<Player,Player> previousPairs) {

        List<Player> santas = new ArrayList<>(players);
        List<Player> children = new ArrayList<>(players);
        Random rand = new Random();

        int attempts = 0;
        while (attempts < Integer.parseInt(AppProperties.get("retry_count.min"))) {
            Collections.shuffle(children, rand);
            boolean isValid = true;
            Map<Player, Player> result = new HashMap<>();

            for (int i = 0; i < santas.size(); i++) {
                Player santa = santas.get(i);
                Player child = children.get(i);

                boolean selfAssignment = santa.equals(child);
                boolean repeatedPair = previousPairs.containsKey(santa) &&
                        previousPairs.get(santa).equals(child);

                if (selfAssignment || repeatedPair) {
                    isValid = false;
                    break;
                }

                result.put(santa, child);
            }

            if (isValid) return result;

            attempts++;
        }

        throw new IllegalStateException("Unable to find a valid assignment after many attempts");
    }
}