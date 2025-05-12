package Everdell.Cards;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public abstract class Card {
    private final String name;
    private final String ability;
    private final TreeMap<Resource, Integer> costs;
    private final boolean isUnique;
    private final int points;


    public Card(String name, String ability,boolean isUnique, int points) {
        this.name = name;
        this.ability = ability;
        costs = new TreeMap<>();
        this.isUnique = isUnique;
        this.points = points;
    }
    public String getName() {
        return name;
    }

    public String getAbility() {
        return ability;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public int getPoints() {
        return points;
    }

    public TreeMap<Resource,Integer> getCosts(){
        return costs;
    }

    /**
     * To be playable a card must not violate the unique constraint or the board size limit.
     * Unique constraint - a maximum of one copy of each unique critter or construction may be on a board.
     * Board size limit - There are a maximum of 15 spaces on a player board.
     * @param player the player playing the card
     * @return true if both of these constraints hold, false otherwise.
     */
    public boolean isPlayable(Player player) {
        return (!isUnique || !player.isCardOnBoard(this)) && player.getBoard().size() < 15;
    }

    /**
     * Adds a card to the appropriate location for the type of card. Triggering any appropriate onplay abilities
     * @param player The player playing the card
     * @param game The game being played
     */
    public  void playCard(Player player, Game game) {
        player.addCardToBoard(this);
    }
}
