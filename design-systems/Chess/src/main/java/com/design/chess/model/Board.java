package com.design.chess.model;

import com.design.chess.model.piece.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> cells;

    public Board(int size) {
        this.size = size;
        this.cells=new ArrayList<>();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i=0;i<this.size;i++) {
            cells.add(new ArrayList<>());
            for (int j=0;j<this.size;j++){
                if(i==1){
                    cells.get(i).add(new Cell(i,j,new Pawn(Color.BLACK)));
                } else if (i==this.size-2) {
                    cells.get(i).add(new Cell(i,j,new Pawn(Color.WHITE)));
                } else if(i==0 ) {
                    if(j==0 || j==this.size-1) {
                        cells.get(i).add(new Cell(i, j, new Rook(Color.BLACK)));
                    } else if(j==1 || j==this.size-2) {
                        cells.get(i).add(new Cell(i, j, new Knight(Color.BLACK)));
                    } else if (j==2 || j==this.size-3) {
                        cells.get(i).add(new Cell(i, j, new Bishop(Color.BLACK)));
                    } else if (j==3) {
                        cells.get(i).add(new Cell(i, j, new King(Color.BLACK)));
                    } else if (j==4) {
                        cells.get(i).add(new Cell(i, j, new Queen(Color.BLACK)));
                    }

                } else if (i==this.size-1) {
                    if(j==0 || j==this.size-1) {
                        cells.get(i).add(new Cell(i, j, new Rook(Color.WHITE)));
                    } else if(j==1 || j==this.size-2) {
                        cells.get(i).add(new Cell(i, j, new Knight(Color.WHITE)));
                    } else if (j==2 || j==this.size-3) {
                        cells.get(i).add(new Cell(i, j, new Bishop(Color.WHITE)));
                    } else if (j==4) {
                        cells.get(i).add(new Cell(i, j, new King(Color.WHITE)));
                    } else if (j==3) {
                        cells.get(i).add(new Cell(i, j, new Queen(Color.WHITE)));
                    }
                } else {
                    cells.get(i).add(new Cell(i,j,null));
                }


            }
        }
    }

    public void displayBoard() {
        for (List<Cell> row : this.getCells()) {
            System.out.print("|");
            for (Cell cell:row) {
                cell.printCell();
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }
}
