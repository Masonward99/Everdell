package Everdell.Locations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Worker;

import java.util.ArrayList;

public class Haven implements Location {
    private final String ability;
    private final ArrayList<Worker> workers;
    public Haven() {
        ability = "Discard any number of cards for every 2 discarded gain 1 any";
        workers = new ArrayList<>();
    }

    @Override
    public boolean canVisit(Player player) {
        return true;
    }

    @Override
    public void visit(Player player, Game game) {
        System.out.println("How many cards would you like to discard?");
        int numDiscarded = game.getInput().getIntInRange(player.getHandSize());
        game.discardCards(numDiscarded, player);
        game.gainAnyResource(numDiscarded, player);
    }

    @Override
    public void returnWorker(Worker worker) {
        workers.remove(worker);
    }

    @Override
    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public String getAbility() {
        return ability;
    }
}
