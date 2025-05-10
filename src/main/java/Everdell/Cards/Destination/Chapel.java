package Everdell.Cards.Destination;

import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

import java.util.TreeMap;

public class Chapel extends Construction implements Destination {
    private Player player;
    private int pointTokens;
    private Worker worker;

    public Chapel() {
        super("Chapel", "Place 1 point token here, then draw 2 cards for each point token",true, 2 );
        TreeMap<Resource, Integer> resources = getCosts();
        resources.put(Resource.TWIGS,2);
        resources.put(Resource.RESIN,1);
        resources.put(Resource.STONES, 1);
        pointTokens = 0;
    }

    @Override
    public boolean canVisit(Worker worker) {
        return worker.getPlayer() == player;
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        pointTokens += 1;
        game.drawCards(pointTokens * 2, player);
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void returnWorker(Worker worker) {
        worker = null;
    }
    public void addWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public int getPoints() {
        return super.getPoints() + pointTokens;
    }
}
