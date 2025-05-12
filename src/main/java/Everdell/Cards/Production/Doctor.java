package Everdell.Cards.Production;


import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;



public class Doctor extends ProductionCritter {
    public Doctor() {
        super("Doctor", "You may pay up to 3 berries to gain 1 point each", true, 4);
        getCosts().put(Resource.BERRIES, 4);
    }

    @Override
    public void action(Player player, Game game) {
        System.out.println("How many berries would you like to pay?");
        int berries = player.getResources().get(Resource.BERRIES);
        int amount = game.getInput().getIntInRange(Math.min(berries, 3));
        player.gainResource(Resource.BERRIES, -amount);
        player.gainResource(Resource.BERRIES, amount);
    }

}
