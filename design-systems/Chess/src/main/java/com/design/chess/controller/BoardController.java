package com.design.chess.controller;

import com.design.chess.model.Board;
import com.design.chess.service.BoardService;

public class BoardController {
    public BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    public void displayBoard(Board board) {
        boardService.displayBoard(board);
    }
}
