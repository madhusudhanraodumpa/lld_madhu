package com.design.tictactoe.models;


import com.design.tictactoe.stratgies.botplayingstrategies.BotPlayingStrategy;
import com.design.tictactoe.stratgies.botplayingstrategies.BotPlayingStrategyFactory;

public class Bot extends Player{

    private BotDifficultLevel botDifficultLevel;

    public Bot(Symbol symbol, String name, BotDifficultLevel botDifficultLevel) {
        super(symbol, name, PlayerType.BOT);
        this.botDifficultLevel = botDifficultLevel;
    }

    public BotDifficultLevel getBotDifficultLevel() {
        return botDifficultLevel;
    }

    public void setBotDifficultLevel(BotDifficultLevel botDifficultLevel) {
        this.botDifficultLevel = botDifficultLevel;
    }
    public Cell makeMove(Board board) {
        BotPlayingStrategy botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDiffcultyType(botDifficultLevel);

        return botPlayingStrategy.makeMove(board);
    }
}
