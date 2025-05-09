package org.example;

import Everdell.Game;
import Everdell.Player;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(2);
        Player player = new Player("p1");
        game.gainAnyResource(2, player);
        System.out.println(player.getResources());
    }


}