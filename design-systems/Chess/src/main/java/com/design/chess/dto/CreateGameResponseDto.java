package com.design.chess.dto;


import com.design.chess.model.Game;

public class CreateGameResponseDto {
    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
