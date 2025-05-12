package Everdell.Cards.BlueGovernance;

import Everdell.Cards.Critter;

public abstract class BlueGovernanceCritter extends Critter implements BlueGovernance {
    public BlueGovernanceCritter(String name, String ability, boolean isUnique, int points) {
        super(name, ability, isUnique, points);
    }
}
