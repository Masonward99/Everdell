package Everdell.Cards.Destination;

import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Cards.TanTraveller.Shepherd;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

import java.util.TreeMap;

public class Chapel extends DestinationConstruction {
    private int pointTokens;

    public Chapel() {
        super("Chapel", "Place 1 point token here, then draw 2 cards for each point token",true, 2 );
        TreeMap<Resource, Integer> resources = getCosts();
        resources.put(Resource.TWIGS,2);
        resources.put(Resource.RESIN,1);
        resources.put(Resource.STONES, 1);
        pointTokens = 0;
    }

    @Override
    public void visit(Player player, Game game) {
        pointTokens += 1;
        game.drawCards(pointTokens * 2, player);
    }

    @Override
    public int getPoints() {
        return super.getPoints() + pointTokens;
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof Shepherd && !isOccupied();
    }
}
