package com.design.chess.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int boardSize;
    private GameStatus gameStatus;
    private Player winner;
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private int nextPlayerIndex;
    private Color playingColorType;
    private boolean isCheckMate;
    private boolean isStaleMate;



    private Game(int boardSize,List<Player> players) {
        this.board= new Board(boardSize);
        this.players=players;
        this.moves=new ArrayList<>();
        this.gameStatus=GameStatus.IN_PROGRESS;
        this.nextPlayerIndex=0;
        this.playingColorType = Color.WHITE;
        this.isCheckMate=false;
        this.isStaleMate=false;
    }
    public Player getCurrentPlayer() {
        if(players !=null && players.get(0).getColor().equals(playingColorType))
            return players.get(0);
        else return players.get(1);
    }

    public Color getPlayingColorType() {
        return playingColorType;
    }

    public void setPlayingColorType(Color playingColorType) {
        this.playingColorType = playingColorType;
    }

    public static Builder getGameBuilder() {
        return new Builder();
    }


    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public boolean isStalemated() {
        return isStaleMate
    }

    public boolean isCheckMate() {
        return isCheckMate;
    }


    public static class  Builder {
        private List<Player> players;
        private int size;

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public int getSize() {
            return size;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }
        public Game build() {

            if(!validateGame()) {
                throw new IllegalArgumentException("Invalid game.");
            }
            Game game = new Game(this.size,this.players);
            return game;
        }
        public boolean validateGame() {
            if(this.players == null || this.players.size()>2) {
                return false;
            }
            if(this.size!=8){
                return false;
            }
            int botCount=0;
            for (Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }
            if(botCount>1) return false;
            List<Color> colors = new ArrayList<>();
            for(Player player : players) {
                if(colors.contains(player.getColor())){
                    return false;
                }else {
                    colors.add(player.getColor());
                }
            }
            return true;
        }
    }
}
