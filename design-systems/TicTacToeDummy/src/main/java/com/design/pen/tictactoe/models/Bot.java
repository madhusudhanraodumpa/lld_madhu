package com.design.pen.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bot extends Player{

    private BotDifficultLevel botDifficultLevel;

    public Bot(Symbol symbol, String name, BotDifficultLevel botDifficultLevel) {
        super(symbol, name, PlayerType.BOT);
        this.botDifficultLevel = botDifficultLevel;
    }
}
