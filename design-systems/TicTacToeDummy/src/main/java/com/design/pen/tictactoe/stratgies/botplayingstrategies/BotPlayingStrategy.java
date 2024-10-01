package com.design.pen.tictactoe.stratgies.botplayingstrategies;

import com.design.pen.tictactoe.models.Board;
import com.design.pen.tictactoe.models.Move;

public interface BotPlayingStrategy {

    Move makeMove(Board board);
}
