package com.design.chess.model.piece;

import com.design.chess.model.*;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean isValidMove(Board board, Cell sourceCell, Cell destiCell) {
        if(!(this.isValidCell(board,sourceCell) && this.isValidCell(board,destiCell))){
            return false;
        }
        if(!sourceCell.getPiece().getColor().equals(this.getColor())) {
            return false;
        }
        if(!destiCell.getCellStatus().equals(CellStatus.EMPTY)  && destiCell.getPiece().getColor().equals(sourceCell.getPiece().getColor())) {
            return false;
        }
        int row = Math.abs(sourceCell.getRow()-destiCell.getRow());
        int col = Math.abs(sourceCell.getCol()-destiCell.getCol());

        if(row==col) {

        //check in between there is no pieces.
        }
        return true;
    }
}
