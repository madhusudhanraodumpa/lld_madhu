package com.design.tictactoe.models;



import com.design.tictactoe.exceptions.InvalidGameException;
import com.design.tictactoe.stratgies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> playerList;
    private List<Move> moveList;
    private GameStatus gameStatus;
    private Board board;
    private int netPlayerIndex;
    private int size;
    private Player winner;
    private List<WinningStrategy> winningStrategyList;

    private Game(List<Player> playerList,int size,List<WinningStrategy> winningStrategyList) {
        this.size = size;
        this.playerList = playerList;
        this.moveList = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.board = new Board(size);
        this.netPlayerIndex = 0;
        this.winningStrategyList = winningStrategyList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getNetPlayerIndex() {
        return netPlayerIndex;
    }

    public void setNetPlayerIndex(int netPlayerIndex) {
        this.netPlayerIndex = netPlayerIndex;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
    }
    public static Builder getGameBuilder() {
        return new Builder();
    }

    public void displayBoard() {
        this.board.printBoard();
    }

    public void makeMove() {
        Player currentPlayer = playerList.get(netPlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn.");

        Cell proposedCell = currentPlayer.makeMove(this.board);
        System.out.println("Move made at row: " + proposedCell.getRow() +
                " col: " + proposedCell.getColumn() + ".");
        if(!validateCell(proposedCell)) {
            System.out.println("Invalid move. Retry.");
            return;

        }
        Cell cell = this.board.getCells().get(proposedCell.getRow()).get(proposedCell.getColumn());
        cell.setCellStatus(CellStatus.FILLED);
        cell.setPlayer(currentPlayer);
        Move move = new Move(cell ,currentPlayer);
        moveList.add(move);
        if(checkGameWon(move,currentPlayer)) return;
        if(checkGameDraw()) return;
        netPlayerIndex +=1;
        netPlayerIndex %=playerList.size();

    }

    private boolean checkGameWon(Move move,Player player) {
        for (WinningStrategy winningStrategy :winningStrategyList) {
            if(winningStrategy.checkWinner(board,move)) {
                this.setGameStatus(GameStatus.END);
                this.winner = player;
                return true;
            }
        }
        return false;
    }

    private boolean checkGameDraw() {
        if(moveList.size() == size*size)  {
            this.gameStatus = GameStatus.DRAW;
            return true;
        }
        return false;
    }

    private boolean validateCell(Cell cell) {
        if(cell.getRow() != -1
                && cell.getColumn() !=-1
                && cell.getRow() > this.size
                && cell.getColumn() > this.size
                )
            return false;
        return this.board.getCells().get(cell.getRow()).get(cell.getColumn()).getCellStatus().equals(CellStatus.EMPTY);

    }

    public void printGameStatus() {
        System.out.println("Game Status : " + gameStatus);
    }

    public void printResult() {
        if(getGameStatus().equals(GameStatus.END)) {
            System.out.println("Game has ended.");
            System.out.println("Winner is : "+winner.getName());
        } else {
            System.out.println("Game is draw.");
        }
        System.out.println();
    }

    public void undo() {
        if(moveList.size() == 0) {
            System.out.println("No move.We can't undo..");
            return;
        }
        Move move = moveList.get(moveList.size()-1);

        for (WinningStrategy winningStrategy :winningStrategyList){
            winningStrategy.handleUndo(this.board,move);
        }
        move.getCell().setCellStatus(CellStatus.EMPTY);
        move.getCell().setPlayer(null);

        moveList.remove(move);
        netPlayerIndex -= 1;
        netPlayerIndex += this.playerList.size();
        netPlayerIndex %= this.playerList.size();
    }

    public void replay() throws InterruptedException {
        Board board1 = new Board(this.size);
        int count = 1;
        for (Move move : moveList) {
            int row = move.getCell().getRow();
            int col = move.getCell().getColumn();
            Cell cell = move.getCell();
            Player player = move.getPlayer();
            Cell cell1 = board1.getCells().get(row).get(col);
            cell1.setCellStatus(cell.getCellStatus());
            cell1.setPlayer(player);
            System.out.println(count + " move played by " + player.getName());
            board1.printBoard();
            count++;
            Thread.currentThread().sleep(3000);

        }


    }

    public static class Builder {
        private List<Player> playerList;
        private List<WinningStrategy> winningStrategyList;
        private int size;

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public Builder setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
            this.winningStrategyList = winningStrategyList;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }
        public Game build() throws InvalidGameException{
            if(!validateGame()) {
                throw new InvalidGameException("Please insert valid inputs.");
            }
            return new Game(this.playerList,this.size,this.winningStrategyList);


        }
        private boolean validateGame() {

            if(playerList.isEmpty() || playerList.size()<2) return false;

            if(playerList.size()!=size-1) return false;
            if(winningStrategyList.isEmpty()) return false;

            List<Character> symbols = new ArrayList<>();
            int botCount=0;
            for (Player player:playerList) {
                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }
            if(botCount>=2) return false;


            for(Player player : playerList) {
                if(symbols.contains(player.getSymbol().geteChar())){
                    return false;
                }else {
                    symbols.add(player.getSymbol().geteChar());
                }
            }

            return true;

        }
    }
}
