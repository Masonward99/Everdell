package Everdell.Cards;

import Everdell.Player;

public abstract class Critter extends Card {
    public Critter(String name, String ability,boolean isUnique, int points) {
        super(name,ability,isUnique,points );
    }

    @Override
    public boolean canBePlayedBy(Player player, int discount) {
        if(!isPlayable(player)) return false;
        else if (player.canOccupyBoard(this)) return true;
        else if(player.getBoard().size() >= 15) return false;
        return (player.hasEnoughResources(getCosts(), discount));
    }
}
