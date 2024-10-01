package com.design.tictactoe.models;




public class Symbol {
    private char eChar;

    public Symbol(char eChar) {
        this.eChar = eChar;
    }

    public char geteChar() {
        return eChar;
    }

    public void seteChar(char eChar) {
        this.eChar = eChar;
    }
}
