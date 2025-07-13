package com.game.utils;

import java.io.IOException;


public interface Parser<T> {
    public T parse(String filePath) throws IOException;
}