package Everdell.Cards.Destination;

import Everdell.BasicLocation.Location;
import Everdell.Player;

public interface Destination extends Location {
    public abstract Player getPlayer();
    public abstract void setPlayer(Player player);
}
