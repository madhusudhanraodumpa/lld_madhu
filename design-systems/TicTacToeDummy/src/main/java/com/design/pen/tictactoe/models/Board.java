package com.design.pen.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private int size;
    private List<List<Cell>> cells;
    public Board(int size) {
        this.size = size;
        this.cells=new ArrayList<>();

        for (int i=0;i<size;i++) {
            cells.add(new ArrayList<>());
            for (int j=0;j<size;j++) {
                cells.get(i).add(new Cell(i,j));
            }
        }
        this.cells = new ArrayList<>();
    }
}
