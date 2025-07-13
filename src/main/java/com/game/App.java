package com.game;

public class App {

    public static void main(String[] args) {

        try {
            GameRunner runner = new GameRunner();
            runner.run();
            System.out.println("Secret Santa successfully generated and saved!");
        } catch (RuntimeException e) {
            System.err.println("Runtime error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
