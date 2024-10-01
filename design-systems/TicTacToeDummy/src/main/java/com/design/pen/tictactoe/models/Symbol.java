package com.design.pen.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Symbol {
    private char eChar;

    public Symbol(char eChar) {
        this.eChar = eChar;
    }
}
