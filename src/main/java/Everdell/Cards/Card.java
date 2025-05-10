package Everdell.Cards;

import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public abstract class Card {
    private final String name;
    private final String ability;
    private final TreeMap<Resource, Integer> costs;
    private final boolean isUnique;
    private final int points;
    public Card(String name, String ability,boolean isUnique, int points) {
        this.name = name;
        this.ability = ability;
        costs = new TreeMap<>();
        this.isUnique = isUnique;
        this.points = points;
    }
    public String getName() {
        return name;
    }

    public TreeMap<Resource,Integer> getCosts(){
        return costs;
    }
    public String getAbility() {
        return ability;
    }
    public boolean isUnique() {
        return isUnique;
    }
    public boolean isPlayable(Player player) {
        return !isUnique || !player.isCardOnBoard(this);
    }
    public int getPoints() {
        return points;
    }

}
