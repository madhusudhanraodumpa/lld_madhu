package com.design.pen.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private Symbol symbol;
    private String name;
    private PlayerType playerType;

    public Player(Symbol symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }
}
