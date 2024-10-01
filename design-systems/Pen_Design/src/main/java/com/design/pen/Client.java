package com.design.pen;

public class Client {
    public static void main(String[] args) {
        Pen pen = PenFactory.createPenByType(PenType.GEL);

    }
}
