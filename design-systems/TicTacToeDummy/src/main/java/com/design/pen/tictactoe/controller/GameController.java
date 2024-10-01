package com.design.pen.tictactoe.controller;

import com.design.pen.tictactoe.models.Player;
import com.design.pen.tictactoe.stratgies.winningstrategies.WinningStrategy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class GameController {

    public void startGame(List<Player> playerList, List<WinningStrategy> winningStrategyList,int dimension) {

    }
}
