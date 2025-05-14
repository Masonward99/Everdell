package Everdell.Cards.Production;



import Everdell.Cards.Critter;
import Everdell.Cards.TanTraveller.Fool;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;


import java.util.TreeMap;

public class Fairgrounds extends ProdutionConstruction {
    public Fairgrounds() {
        super("Fairgrounds", "Draw 2 cards", true, 3);
        TreeMap<Resource, Integer> resources = getCosts();
        resources.put(Resource.TWIGS, 1);
        resources.put(Resource.RESIN, 2);
        resources.put(Resource.STONES, 1);
    }

    @Override
    public void action(Player player, Game game) {
        game.drawCards(2, player);
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof Fool && !isOccupied();
    }
}
