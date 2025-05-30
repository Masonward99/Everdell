package Everdell.Events.SpecialEvent;

import Everdell.Cards.BlueGovernance.BlueGovernance;
import Everdell.Cards.Card;
import Everdell.Cards.Destination.Destination;
import Everdell.Cards.Production.Production;
import Everdell.Cards.Prosperity.Prosperity;
import Everdell.Cards.TanTraveller.TanTraveller;
import Everdell.Game;
import Everdell.Player;
import Everdell.Worker;

import java.util.ArrayList;

public class TheEverdellGames extends SpecialEvent {
    public TheEverdellGames() {
        super("The Everdell Games", "Have 2 cards of each color in your city", "9 points at end of game");
    }

    @Override
    public boolean canVisit(Player player) {
        int countBlue = 0;
        int countTan = 0;
        int countProsperity = 0;
        int countDestination = 0;
        int countProduction = 0;
        ArrayList<Card> cards = player.getBoard();
        cards.addAll(player.getPlayedNonBoardCards());
        for (Card card : cards) {
            if (card instanceof BlueGovernance) countBlue++;
            else if (card instanceof TanTraveller) countTan++;
            else if (card instanceof Prosperity) countProsperity++;
            else if (card instanceof Destination) countDestination++;
            if (card instanceof Production) countProduction++;
            if (countBlue >= 2 && countProduction >= 2 && countDestination >= 2 && countProsperity >= 2 && countTan >= 2) return true  ;
        }
        return false;
    }

    @Override
    public int getEndGamePoints() {
        return 9;
    }

    @Override
    public void visit(Player player, Game game) {
        return;
    }
}
