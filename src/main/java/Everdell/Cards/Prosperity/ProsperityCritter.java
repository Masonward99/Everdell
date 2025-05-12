package Everdell.Cards.Prosperity;

import Everdell.Cards.Critter;

public abstract class ProsperityCritter extends Critter implements Prosperity{
    public ProsperityCritter(String name, String ability, boolean isUnique, int points ) {
        super(name, ability, isUnique, points);
    }
}
