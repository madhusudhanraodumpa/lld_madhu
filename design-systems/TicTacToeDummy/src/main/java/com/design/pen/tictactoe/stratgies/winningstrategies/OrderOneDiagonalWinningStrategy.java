package com.design.pen.tictactoe.stratgies.winningstrategies;

import com.design.pen.tictactoe.models.Board;
import com.design.pen.tictactoe.models.Move;

public class OrderOneDiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
