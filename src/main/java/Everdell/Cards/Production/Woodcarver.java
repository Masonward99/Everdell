package Everdell.Cards.Production;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;


public class Woodcarver extends Critter implements Production{
    public Woodcarver() {
        super("Woodcarver", "You may pay up to 3 twigs to gain 1 point token each", false, 2);
        getCosts().put(Resource.BERRIES, 2);
    }

    @Override
    public void action(Player player, Game game) {
        System.out.println("How many twigs would you like to pay?");
        int twigs = player.getResources().get(Resource.TWIGS);
        int amount = game.getInput().getIntInRange(Math.min(3, twigs));
        player.gainResource(Resource.TWIGS, -amount);
        player.gainPointTokens(amount);
    }
}
