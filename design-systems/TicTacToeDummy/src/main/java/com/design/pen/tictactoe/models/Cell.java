package com.design.pen.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int column;
    private Player player;
    private CellStatus cellStatus;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellStatus=CellStatus.EMPTY;
    }
}
