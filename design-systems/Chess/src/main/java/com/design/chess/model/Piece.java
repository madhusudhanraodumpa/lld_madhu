package com.design.chess.model;

public abstract class Piece {
    private PieceType pieceType;
    private boolean isKilled;
    private Color color;

    public Piece(PieceType pieceType,Color color) {
        this.pieceType = pieceType;
        this.isKilled=false;
        this.color = color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract boolean isValidMove(Board board,Cell sourceCell,Cell destiCell);
    public boolean isValidCell(Board board,Cell cell) {
        if(cell.getRow() >= 0 && cell.getCol() >=0 && cell.getRow()<=board.getSize()-1 && cell.getCol()<=board.getSize()-1) {
            return true;
        }
        return false;
    }

}
