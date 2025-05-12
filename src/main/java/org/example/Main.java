package org.example;

import Everdell.Cards.Card;
import Everdell.Cards.Destination.Queen;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.Production.ResinRefinery;
import Everdell.Cards.Prosperity.Castle;
import Everdell.Cards.TanTraveller.PostalPigeon;
import Everdell.Game;
import Everdell.InputReader;
import Everdell.Player;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(0);
        Player player = new Player("Steve");
        Queen queen = new Queen();
        player.addCard(queen);
        player.addCardToBoard(queen);
        player.addCard(new Castle());
        player.addCard(new ResinRefinery());
        queen.visit(player, game);

        System.out.println(player.getBoard());
        System.out.println(game.getDiscard());
        System.out.println(player.getResources());
    }

}