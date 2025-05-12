package Everdell.Locations.BasicLocation;

import Everdell.Player;

public abstract class ExclusiveBasicLocation extends BasicLocation {
    public ExclusiveBasicLocation(String name) {
        super(name);
    }

    @Override
    public boolean canVisit(Player player) {
        return getWorkers().isEmpty();
    }
}
