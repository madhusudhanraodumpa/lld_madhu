package com.design.chess;

import com.design.chess.controller.BoardController;
import com.design.chess.controller.GameController;
import com.design.chess.dto.CreateGameRequestDto;
import com.design.chess.dto.CreateGameResponseDto;
import com.design.chess.model.Color;
import com.design.chess.model.Game;
import com.design.chess.model.Player;
import com.design.chess.model.PlayerType;
import com.design.chess.service.BoardService;
import com.design.chess.service.GameService;
import com.design.chess.service.PlayerService;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController(new PlayerService(new BoardService()),new GameService(new PlayerService(new BoardService())));
        BoardController boardController = new BoardController(new BoardService());


        CreateGameRequestDto createGameRequestDto = new CreateGameRequestDto();
        createGameRequestDto.setBoardSize(8);
        createGameRequestDto.setBlackPlayerId(1);
        createGameRequestDto.setWhitePlayerId(2);
        Game game = gameController.createGame(createGameRequestDto).getGame();
        while (!game.isCheckMate() || !game.isStalemated()) {
            boardController.displayBoard(game.getBoard());
            game = gameController.makeMove(game);
        }

    }
}