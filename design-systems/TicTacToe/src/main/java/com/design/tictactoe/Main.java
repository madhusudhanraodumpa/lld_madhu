package com.design.tictactoe;

import com.design.tictactoe.controller.GameController;
import com.design.tictactoe.exceptions.InvalidGameException;
import com.design.tictactoe.models.*;
import com.design.tictactoe.stratgies.winningstrategies.OrderOneColumnWinningStrategy;
import com.design.tictactoe.stratgies.winningstrategies.OrderOneDiagonalWinningStrategy;
import com.design.tictactoe.stratgies.winningstrategies.OrderOneRowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidGameException, InterruptedException {
        // 1. create game
        GameController gameController = new GameController();
        int dimension=3;
        List<Player> playerList = List.of(
                new Player(new Symbol('X'),"madhu", PlayerType.HUMAN),
                new Bot(new Symbol('O'),"Bot",BotDifficultLevel.EASY));

        Game game = gameController.createGame(dimension,playerList,
                List.of(new OrderOneColumnWinningStrategy(dimension,playerList),new OrderOneRowWinningStrategy(dimension,playerList),new OrderOneDiagonalWinningStrategy(dimension,playerList)));


        Scanner sc= new Scanner(System.in);

        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            gameController.displayBoard(game);
            System.out.println("Do you want to do undo (y/n)");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("y")){
                gameController.doUndo(game);
            } else {
                gameController.makeMove(game);
            }


        }
        gameController.printGameStatus(game);
        gameController.printGameResult(game);
        System.out.println("Do you want replay the game:(y/n)");
        String replayInput = sc.next();
        if(replayInput.equalsIgnoreCase("y")) {
            gameController.rePlay(game);
        }


        //3.take user input move or undo . if yes then do undo or else make move.untill game ends or draw.
        //2.print the board
        //print the game winner and status

    }
}