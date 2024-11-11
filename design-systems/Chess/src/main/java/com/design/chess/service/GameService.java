package com.design.chess.service;

import com.design.chess.model.Board;
import com.design.chess.model.Color;
import com.design.chess.model.Game;
import com.design.chess.model.Player;

import java.util.List;
import java.util.Locale;

public class GameService {
    private PlayerService playerService;

    public GameService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Game createGame(int boardSize, List<Player> players) {
        Game game = Game.getGameBuilder().setPlayers(players).setSize(boardSize).build();
        return game;

    }


    public Game makeMove(Game game) {

        Player player = game.getCurrentPlayer();
        System.out.println("Player: " +player.getName()+"  "+player.getColor()+" tour(n)");

        Board board = playerService.makeMove(game.getBoard(),player);
        game.setBoard(board);
        game.setPlayingColorType(player.getColor().equals(Color.WHITE) ?Color.BLACK : Color.WHITE);
        return game;



    }
}
