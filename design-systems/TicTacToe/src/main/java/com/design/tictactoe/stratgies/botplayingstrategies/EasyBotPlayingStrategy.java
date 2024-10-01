package com.design.tictactoe.stratgies.botplayingstrategies;

import com.design.tictactoe.models.Board;
import com.design.tictactoe.models.Cell;
import com.design.tictactoe.models.CellStatus;
import com.design.tictactoe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell makeMove(Board board) {

        for (List<Cell> row :board.getCells()) {
            for(Cell cell : row) {
                if(cell.getCellStatus().equals(CellStatus.EMPTY)) {
                    return cell;
                }

            }
        }
        return null;
    }
}
