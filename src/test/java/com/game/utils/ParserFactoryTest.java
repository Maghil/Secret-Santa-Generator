package com.game.utils;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ParserFactoryTest {
    @Test
    public void testGetPlayerParser() {
        Parser<?> parser = ParserFactory.getParser("player");

        assertTrue(parser instanceof PlayerListParser);
    }

    @Test
    public void testGetPreviousGameParser() {
        Parser<?> parser = ParserFactory.getParser("previous_game");

        assertTrue(parser instanceof PrevousGameParser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetUndefinedParser() {
        ParserFactory.getParser("invalid");
    }
}
