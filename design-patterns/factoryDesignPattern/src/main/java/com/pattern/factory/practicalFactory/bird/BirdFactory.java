package com.pattern.factory.practicalFactory.bird;

public class BirdFactory {

    public static Bird createdBirdType(BirdType birdType) {

        return switch (birdType) {
            case HEN -> new Hen();
            case SPARROW -> new Sparrow();
            case CROW -> new Crow();
            case PEACOCK -> new Peacock();
            default -> new Bird();
        };
    }
    public static Bird createdBirdStringType(String birdType) {

        if(birdType.equalsIgnoreCase("HEN")){
            return new Hen();
        }else if(birdType.equalsIgnoreCase("SPARROW")){
            return new Sparrow();
        }
        else if(birdType.equalsIgnoreCase("CROW")){
            return new Crow();
        }
        else if(birdType.equalsIgnoreCase("PEACOCK")){
            return new Peacock();
        }else {
            return new Bird();
        }

    }
    public static Bird createdSeasonType(Season season) {

       return null;
    }
}
