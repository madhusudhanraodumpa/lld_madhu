package com.design.chess.model;

public class Cell {
    private int row;
    private int col;
    private CellStatus cellStatus;
    private Piece piece;

    public Cell(int row,int col,Piece piece) {
        this.row=row;
        this.col=col;
        if(piece==null)
        this.cellStatus=CellStatus.EMPTY;
        else {
            this.piece=piece;
            this.cellStatus=CellStatus.FILLED;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void printCell() {
        System.out.print((getCellStatus().equals(CellStatus.EMPTY) ? " -" :
                " "+this.getPiece().getPieceType()+"("+this.getPiece().getColor().getSymbol()+")")
                +" |");
    }
}
