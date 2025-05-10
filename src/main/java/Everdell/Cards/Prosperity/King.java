package Everdell.Cards.Prosperity;

import Everdell.Cards.Critter;
import Everdell.Events.BasicEvents.BasicEvent;
import Everdell.Events.Event;
import Everdell.Player;
import Everdell.Resource;

public class King extends Critter implements Prosperity {
    public King() {
        super("King", "Gain 1 point for each basic event, and 2 for each special event", true, 4);
        getCosts().put(Resource.BERRIES, 6);
    }

    @Override
    public int bonusPoints(Player player) {
        int count = 0;
        for (Event event : player.getCompletedEvents()){
            if (event instanceof BasicEvent){
                count++;
            }
            else {
                count += 2;
            }
        }
        return count;
    }
}
