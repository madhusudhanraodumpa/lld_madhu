package com.design.tictactoe.stratgies.winningstrategies;


import com.design.tictactoe.models.Board;
import com.design.tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
    void handleUndo(Board board,Move move);

}
