package com.design.chess.model;

import java.awt.*;

public class Bot extends Player{
    private BotDifficultLevel botDifficultLevel;

    public Bot(String name, PlayerType playerType, Color color, BotDifficultLevel botDifficultLevel) {
        super(name, playerType, color);
        this.botDifficultLevel = botDifficultLevel;
    }

    public BotDifficultLevel getBotDifficultLevel() {
        return botDifficultLevel;
    }

    public void setBotDifficultLevel(BotDifficultLevel botDifficultLevel) {
        this.botDifficultLevel = botDifficultLevel;
    }
}
