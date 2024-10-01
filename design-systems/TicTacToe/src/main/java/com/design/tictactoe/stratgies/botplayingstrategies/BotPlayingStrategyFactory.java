package com.design.tictactoe.stratgies.botplayingstrategies;

import com.design.tictactoe.models.BotDifficultLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyByDiffcultyType(BotDifficultLevel botDifficultLevel) {
        return switch(botDifficultLevel) {
//            case EASY -> new EasyBotPlayingStrategy();
//            case MEDIUM -> new MediumBotPlayingStrategy();
//            case HARD -> new HardBotPlayingStrategy();
            default ->  new EasyBotPlayingStrategy();
        };
    }
}
