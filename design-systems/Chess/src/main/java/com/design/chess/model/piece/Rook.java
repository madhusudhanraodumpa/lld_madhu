package com.design.chess.model.piece;

import com.design.chess.model.*;

public class Rook extends Piece {
    public Rook(Color color) {
        super(PieceType.ROCK,color);
    }


    @Override
    public boolean isValidMove(Board board, Cell sourceCell, Cell destiCell) {
        return true;
    }
}
