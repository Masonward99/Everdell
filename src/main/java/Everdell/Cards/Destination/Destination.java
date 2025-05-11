package Everdell.Cards.Destination;

import Everdell.BasicLocation.Location;
import Everdell.Player;

public interface Destination extends Location {
    Player getPlayer();
    void setPlayer(Player player);
}
