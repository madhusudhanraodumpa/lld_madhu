package com.design.chess.service;

import com.design.chess.model.Board;
import com.design.chess.model.Cell;

public class BoardService {
    public void displayBoard(Board board) {
        if(board!=null) {
            board.displayBoard();
        }
    }

    public Cell getCell(int sourceRow, int sourceCol, Board board) {
        return board.getCells().get(sourceRow).get(sourceCol);

    }
}
