package com.design.chess.model;

public enum Color {
    BLACK("B"),WHITE("W"),NONW("N");
    private String symbol;

    Color(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return  symbol;
    }


}
