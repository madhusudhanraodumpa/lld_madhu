package com.design.chess.service;

import com.design.chess.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayerService {
    private BoardService boardService;
    Map<Integer,Player> playerMap= new HashMap<>();
    private Scanner scanner;
    public PlayerService(BoardService boardService) {
        playerMap.put(1,new Player("madhu", PlayerType.HUMAN, Color.WHITE));
        playerMap.put(2,new Player("Raju",PlayerType.BOT,Color.BLACK));
        this.scanner = new Scanner(System.in);
        this.boardService = boardService;
    }
    public Player getPlayerByID(int playerId) {
        return playerMap.get(playerId);
    }

    public Board makeMove(Board board,Player player) {
        System.out.println("Please tell source row number (starting from 0)");
        int sourceRow = scanner.nextInt();

        System.out.println("Please tell source col number (starting from 0)");
        int sourceCol = scanner.nextInt();

        System.out.println("Please tell dest. row number (starting from 0)");
        int destiRow = scanner.nextInt();

        System.out.println("Please tell dest. col number (starting from 0)");
        int destiCol = scanner.nextInt();

        Cell sourceCell = boardService.getCell(sourceRow,sourceCol,board);

        Cell destiCell = boardService.getCell(destiRow,destiCol,board);;
        boolean isValidMove = false;
        if(sourceCell.getCellStatus().equals(CellStatus.FILLED)) {
            if(!sourceCell.getPiece().getColor().equals(player.getColor())) {
                throw new IllegalArgumentException("Please enter valid move.");
            }
            isValidMove = sourceCell.getPiece().isValidMove(board,sourceCell,destiCell);
        }

        if(isValidMove){
            if(destiCell.getCellStatus().equals(CellStatus.FILLED)){
                destiCell.getPiece().setKilled(true);
            }
            destiCell.setPiece(sourceCell.getPiece());
            destiCell.getPiece().setPieceType(sourceCell.getPiece().getPieceType());
            destiCell.getPiece().setColor(sourceCell.getPiece().getColor());
            board.getCells().get(destiRow).get(destiCol).setCellStatus(CellStatus.FILLED);
            board.getCells().get(destiRow).get(destiCol).setPiece(destiCell.getPiece());
            board.getCells().get(sourceRow).get(sourceCol).setCellStatus(CellStatus.EMPTY);
        }

        return board;
 }
}
