package com.design.tictactoe.stratgies.winningstrategies;

import com.design.tictactoe.models.Board;
import com.design.tictactoe.models.Move;
import com.design.tictactoe.models.Player;
import com.design.tictactoe.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneRowWinningStrategy implements WinningStrategy{
    private List<Map<Symbol,Integer>> rowMapList;

    public OrderOneRowWinningStrategy(int size, List<Player> playerList) {
        rowMapList = new ArrayList<>();
        for (int i=0;i<size;i++) {
            Map<Symbol,Integer> rowMap = new HashMap<>();
            rowMapList.add(rowMap);
            for (Player player : playerList) {
                rowMapList.get(i).put(player.getSymbol(),0);
            }
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        rowMapList.get(row).put(symbol,rowMapList.get(row).get(symbol)+1);
        if(rowMapList.get(row).get(symbol)==board.getSize()) return true;
        return false;


    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        rowMapList.get(row).put(symbol,rowMapList.get(row).get(symbol)-1);
    }
}
