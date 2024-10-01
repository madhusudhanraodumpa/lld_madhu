package com.design.tictactoe.stratgies.winningstrategies;
import com.design.tictactoe.models.Board;
import com.design.tictactoe.models.Move;
import com.design.tictactoe.models.Player;
import com.design.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneDiagonalWinningStrategy implements WinningStrategy{
    Map<Symbol,Integer> rightDiagonalMap;
    Map<Symbol,Integer> leftDiagonalMap;
    public OrderOneDiagonalWinningStrategy(int size, List<Player> playerList) {
        rightDiagonalMap = new HashMap<>();
        leftDiagonalMap = new HashMap<>();

        for (Player player :playerList) {
            rightDiagonalMap.put(player.getSymbol(),0);
            leftDiagonalMap.put(player.getSymbol(),0);
        }

    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        if(row==col) {
            leftDiagonalMap.put(symbol,leftDiagonalMap.get(symbol)+1);
        }
        if(row+col== board.getSize()-1) {
            rightDiagonalMap.put(symbol,rightDiagonalMap.get(symbol)+1);
        }
        if(row==col) {
            if(leftDiagonalMap.get(symbol)==board.getSize()) return true;
        }
        if(row+col==board.getSize()-1){
            if (rightDiagonalMap.get(symbol) == board.getSize()) return true;
        }
        return false;

    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        if(col==row) {
            leftDiagonalMap.put(symbol,leftDiagonalMap.get(symbol)-1);
        }
        if(col+row==board.getSize()-1) {
            rightDiagonalMap.put(symbol,rightDiagonalMap.get(symbol)-1);
        }

    }
}
