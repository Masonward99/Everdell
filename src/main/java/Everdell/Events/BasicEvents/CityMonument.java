package Everdell.Events.BasicEvents;

import Everdell.Cards.BlueGovernance.BlueGovernance;
import Everdell.Cards.Card;
import Everdell.Player;
import Everdell.Worker;

public class CityMonument extends BasicEvent {
    public CityMonument() {
        super("City Monument", "Have 3 Blue Governance cards in your city");
    }

    @Override
    public boolean canVisit(Worker worker) {
        Player player = worker.getPlayer();
        int count = 0;
        for(Card card : player.getBoard()){
            if (card instanceof BlueGovernance) count++;
            if (count >= 3) return true;
        }
        return false;
    }
}
