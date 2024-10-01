package com.design.tictactoe.controller;

import com.design.tictactoe.exceptions.InvalidGameException;
import com.design.tictactoe.models.Game;
import com.design.tictactoe.models.Player;
import com.design.tictactoe.stratgies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int size, List<Player> playerList, List<WinningStrategy> winningStrategyList) throws InvalidGameException {
        return Game.getGameBuilder().setPlayerList(playerList).setSize(size).setWinningStrategyList(winningStrategyList).build();
    }
    public void displayBoard(Game game) {
        game.displayBoard();
    }
    public void makeMove(Game game) {
        game.makeMove();

    }
    public void doUndo(Game game) {
        game.undo();

    }
    public void printGameResult(Game game) {
        game.printResult();

    }
    public void printGameStatus(Game game) {
        game.printGameStatus();

    }
    public void rePlay(Game game) throws InterruptedException {
        game.replay();
    }
}
