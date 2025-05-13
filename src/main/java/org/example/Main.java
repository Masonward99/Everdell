package org.example;


import Everdell.Cards.Destination.Monastery;
import Everdell.Cards.Production.Monk;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(2);
        Player player1 = game.getPlayers()[0];
        Player player2 = game.getPlayers()[1];
        player1.gainResource(Resource.STONES, 5);
        Monastery monastery = new Monastery();
        monastery.playCard(player1, game);
        game.visitLocation(player1, monastery);
        System.out.println(monastery.canVisit(player1));
        player1.addCardToBoard(new Monk());
        System.out.println(monastery.canVisit(player1));
        System.out.println(player1.getPointTokens());
        System.out.println(player2.getResources());
        System.out.println(player1.getResources());
    }

}