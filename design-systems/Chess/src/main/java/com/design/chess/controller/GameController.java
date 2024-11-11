package com.design.chess.controller;

import com.design.chess.dto.CreateGameRequestDto;
import com.design.chess.dto.CreateGameResponseDto;
import com.design.chess.model.Game;
import com.design.chess.model.Player;
import com.design.chess.service.GameService;
import com.design.chess.service.PlayerService;

import java.util.List;

public class GameController {
    private PlayerService playerService;
    private GameService gameService;
    public GameController(PlayerService playerService,GameService gameService) {
        this.playerService= playerService;
        this.gameService = gameService;
    }

    public CreateGameResponseDto createGame(CreateGameRequestDto createGameRequestDto) {
        Player whitePlayer = playerService.getPlayerByID(createGameRequestDto.getWhitePlayerId());
        Player blackPlayer = playerService.getPlayerByID(createGameRequestDto.getBlackPlayerId());
        Game game = gameService.createGame(createGameRequestDto.getBoardSize(), List.of(whitePlayer,blackPlayer));
        CreateGameResponseDto createGameResponseDto = new CreateGameResponseDto();
        createGameResponseDto.setGame(game);
        return createGameResponseDto;
   }
   public Game makeMove(Game game) {
       return this.gameService.makeMove(game);
   }


}
