package Everdell.Events.BasicEvents;

import Everdell.Cards.Card;
import Everdell.Cards.Production.Production;
import Everdell.Worker;
import Everdell.Player;

public class HarvestFestival extends BasicEvent {
    public HarvestFestival() {
        super("Harvest Festival", "Have 4 production cards in your city");
    }

    @Override
    public boolean canVisit(Player player) {
        int count = 0;
        for (Card card : player.getBoard()){
            if (card instanceof Production){
                count++;
            }
            if (count >= 4){
                return true;
            }
        }
        return false;
    }
}
