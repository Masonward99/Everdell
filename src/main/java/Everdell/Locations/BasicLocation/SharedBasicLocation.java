package Everdell.Locations.BasicLocation;

import Everdell.Player;

public abstract class SharedBasicLocation extends BasicLocation {
    public SharedBasicLocation(String name) {
        super(name);
    }

    @Override
    public boolean canVisit(Player player) {
        return true;
    }
}
