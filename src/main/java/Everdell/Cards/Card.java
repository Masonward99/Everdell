package Everdell.Cards;

import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public abstract class Card {
    private final String name;
    private final String ability;
    private final TreeMap<Resource, Integer> costs;
    private final boolean isUnique;
    public Card(String name, String ability,boolean isUnique) {
        this.name = name;
        this.ability = ability;
        costs = new TreeMap<>();
        this.isUnique = isUnique;
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

}
