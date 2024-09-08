package com.pattern.factory.practicalFactory.client;

import com.pattern.factory.practicalFactory.bird.Bird;
import com.pattern.factory.practicalFactory.bird.BirdFactory;
import com.pattern.factory.practicalFactory.bird.BirdType;

public class Client {
    public static void main(String[] args) {
        BirdType birdType=BirdType.HEN;
        Bird bird;

//        if(birdType.equals(BirdType.HEN)) {
//            bird=new Bird();
//        }
//        else if(birdType.equals(BirdType.SPARROW)) {
//            bird=new Sparrow();
//        }

        Bird bird1= BirdFactory.createdBirdType(BirdType.CROW);


    }
}
