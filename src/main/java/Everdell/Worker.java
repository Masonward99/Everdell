package Everdell;

import Everdell.BasicLocation.Location;

public class Worker {
    private Location location;
    private final Player player;
    private boolean canBeReturned = true;

    public Worker( Player player) {
        this.player = player;
        location = null;
    }
    public boolean isAvailable () {
        return location == null;
    }
    public void returnWorker (){
        location.returnWorker(this);
        location = null;
    }
    public Player getPlayer() {
        return player;
    }
    public void placeWorker(Location location) {
        this.location = location;
    }
    public boolean canBeReturned () {
        return canBeReturned;
    }
    public void setCantReturn () {
        canBeReturned = false;
    }
    public Location getLocation () {
        return location;
    }
}
