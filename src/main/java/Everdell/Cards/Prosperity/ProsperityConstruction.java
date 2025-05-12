package Everdell.Cards.Prosperity;

import Everdell.Cards.Construction;

public abstract class ProsperityConstruction extends Construction implements Prosperity {
    public ProsperityConstruction(String name, String ability, boolean isUnique, int points) {
        super(name, ability, isUnique, points);
    }
}
