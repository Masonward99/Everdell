package Everdell.Cards;

import Everdell.Player;

public abstract class  Construction extends Card {
    private boolean isOccupied;
    public Construction(String name, String ability,boolean isUnique, int points) {
        super(name,ability,isUnique, points);
        this.isOccupied = false;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied() {
        this.isOccupied = true;
    }
    public boolean canBeOccupiedBy (Critter critter) {
        return true;
    }

    @Override
    public boolean canBePlayedBy(Player player, int discount) {
        if (!isPlayable(player)) return false;
        else if(player.getBoard().size() >= 15) return false;
        return player.hasEnoughResources(getCosts(), discount);
    }
}
