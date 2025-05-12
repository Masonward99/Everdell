package Everdell.Events.BasicEvents;

import Everdell.Cards.Card;
import Everdell.Cards.Destination.Destination;
import Everdell.Player;
import Everdell.Worker;

public class GrandTour extends BasicEvent {
    public GrandTour() {
        super("Grand Tour", "Have 3 destination cards in your city");
    }

    @Override
    public boolean canVisit(Player player) {
        int count = 0;
        for (Card card : player.getBoard()){
            if (card instanceof Destination){
                count++;
            }
            if (count >= 3 ){
                return true;
            }
        }
        return false;
    }
}
