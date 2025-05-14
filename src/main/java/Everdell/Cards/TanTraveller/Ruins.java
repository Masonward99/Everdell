package Everdell.Cards.TanTraveller;

import Everdell.Cards.Card;
import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Cards.Production.Peddler;
import Everdell.Game;
import Everdell.Player;

import java.util.ArrayList;

public class Ruins extends TanConstruction{
    public Ruins(){
        super("Ruins", "Discard a construction from your city. Gain resources equal to the constructions cost and draw 2 cards", false, 0);
    }

    @Override
    public void action(Player player, Game game) {
        ArrayList<Card> constructions = new ArrayList<>();
        for (Card card : player.getBoard()){
            if(card instanceof Construction){constructions.add( card);}
        }
        Card card = game.getInput().getCardFromUser(constructions);
        //never returns null as must have at least one construction on board to be played
        game.discardCardFromBoard(card, player);
        player.gainResources(card.getCosts());
        game.drawCards(2, player);
    }

    @Override
    public boolean isPlayable(Player player, Game game) {
        //board size must be less than 15 and at least one construction on board
        if (player.getBoard().size() >= 15) return false;
        for (Card card : player.getBoard()){
            if (card instanceof Construction)return true;
        }
        return false;
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof Peddler && !isOccupied();
    }
}
