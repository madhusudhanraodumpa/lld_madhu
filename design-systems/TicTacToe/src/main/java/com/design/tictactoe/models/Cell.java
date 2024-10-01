package com.design.tictactoe.models;




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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public void printCell() {
        System.out.print((getCellStatus().equals(CellStatus.EMPTY) ? " -" :
                " "+getPlayer().getSymbol().geteChar())
                +" |");
    }
}
