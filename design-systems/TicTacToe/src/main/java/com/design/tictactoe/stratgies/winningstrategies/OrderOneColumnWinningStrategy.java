package com.design.tictactoe.stratgies.winningstrategies;

import com.design.tictactoe.models.Board;
import com.design.tictactoe.models.Move;
import com.design.tictactoe.models.Player;
import com.design.tictactoe.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneColumnWinningStrategy implements WinningStrategy{
    private List<Map<Symbol,Integer>> colMapList;

    public OrderOneColumnWinningStrategy(int size, List<Player> playerList) {
        colMapList = new ArrayList<>();
        for (int i=0;i<size;i++) {
            Map<Symbol,Integer> rowMap = new HashMap<>();
            colMapList.add(rowMap);
            for (Player player : playerList) {
                colMapList.get(i).put(player.getSymbol(),0);
            }
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        colMapList.get(col).put(symbol, colMapList.get(col).get(symbol)+1);
        if(colMapList.get(col).get(symbol)==board.getSize()) return true;
        return false;


    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col = move.getCell().getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        colMapList.get(col).put(symbol,colMapList.get(col).get(symbol)-1);

    }
}
