package com.stevenpj.library;

public class MatchUpdate {
    private String club;
    private String player;
    private String action;
    private String score;

    public MatchUpdate(String club, String player, String action, String score) {
        this.club = club;
        this.player = player;
        this.action = action;
        this.score = score;
    }

    public String toString() {
        return String.format("%s: %s %s. SCORE: %s", club, player, action, score);
    }
}