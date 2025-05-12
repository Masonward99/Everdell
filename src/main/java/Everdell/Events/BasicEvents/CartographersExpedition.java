package Everdell.Events.BasicEvents;

import Everdell.Cards.Card;
import Everdell.Cards.TanTraveller.TanTraveller;
import Everdell.Player;
import Everdell.Worker;

import java.util.ArrayList;

public class CartographersExpedition extends BasicEvent {
    public CartographersExpedition() {
        super("Cartographers' Expedition", "Have 3 Tan Travellers in your city");
    }

    @Override
    public boolean canVisit(Player player) {
        int count = 0;
        ArrayList<Card> cards = player.getBoard();
        cards.addAll(player.getPlayedNonBoardCards());
        for (Card card : cards) {
            if (card instanceof TanTraveller){
                count++;
            }
            if (count >= 3){
                return true;
            }
        }
        return false;
    }
}
