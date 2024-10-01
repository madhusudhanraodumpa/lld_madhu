package com.design.tictactoe.stratgies.botplayingstrategies;

import com.design.tictactoe.models.Board;
import com.design.tictactoe.models.Cell;
import com.design.tictactoe.models.Move;

public interface BotPlayingStrategy {

    Cell makeMove(Board board);
}
