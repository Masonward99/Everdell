package Everdell.Cards.BlueGovernance;

import Everdell.Cards.Construction;

public abstract class BlueGovernanceConstruction extends Construction implements BlueGovernance{
    public BlueGovernanceConstruction(String name, String ability, boolean isUnique, int points){
        super(name, ability, isUnique, points);
    }
}
