package com.design.chess.model;


import java.util.Scanner;

public class Player {
    private String name;
    private int age;
    private PlayerType playerType;
    private Color color;
    private Scanner scanner;

    public Player(String name, PlayerType playerType, Color color) {
        this.name = name;
        this.playerType = playerType;
        this.color = color;
        this.scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
