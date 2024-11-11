package com.design.chess.model.piece;

import com.design.chess.model.*;

public class Queen extends Piece {
    public Queen(Color color) {
        super(PieceType.QUEEN,color);
    }


    @Override
    public boolean isValidMove(Board board, Cell sourceCell, Cell destiCell) {
        return false;
    }
}
