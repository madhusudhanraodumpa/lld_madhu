package com.design.pen.tictactoe.models;

import com.design.pen.tictactoe.stratgies.winningstrategies.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Game {
    private List<Player> playerList;
    private List<Move> moveList;
    private GameStatus gameStatus;
    private Board board;
    private int netPlayerIndex;
    private int size;
    private Player winner;
    private List<WinningStrategy> winningStrategyList;

    public Game(List<Player> playerList,int size,List<WinningStrategy> winningStrategyList) {
        this.size = size;
        this.playerList = playerList;
        this.moveList = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.board = new Board(size);
        this.netPlayerIndex = 0;
        this.winningStrategyList = winningStrategyList;
    }
}
