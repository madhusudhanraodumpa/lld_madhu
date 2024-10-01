package com.design.pen;

public class PenFactory {


    public static Pen createPenByType(PenType penType) {
        return switch (penType){
            case GEL -> new BallPen();
            case BALL -> new BallPen();
            case FOUNTAIN -> new FountainPen();
        };

    }
}
