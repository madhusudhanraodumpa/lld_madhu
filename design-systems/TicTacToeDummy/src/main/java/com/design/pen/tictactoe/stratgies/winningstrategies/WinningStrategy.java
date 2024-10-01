package com.design.pen.tictactoe.stratgies.winningstrategies;

import com.design.pen.tictactoe.models.Board;
import com.design.pen.tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);

}
