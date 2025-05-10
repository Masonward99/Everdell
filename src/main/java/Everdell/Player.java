package Everdell;

import Everdell.Cards.BlueGovernance.Shopkeeper;
import Everdell.Cards.Card;
import Everdell.Cards.Critter;
import Everdell.Cards.Production.Farm;
import Everdell.Events.Event;


import java.util.ArrayList;
import java.util.TreeMap;

public class Player {
    private final TreeMap<Resource, Integer> resources;
    private int pointTokens;
    private final String name;
    private final ArrayList<Card> hand;
    private final ArrayList<Card> board;
    private final ArrayList<Card> playedNonBoardCards;
    private final ArrayList<Event> completedEvents;
    public static final int HAND_LIMIT = 8;
    private final ArrayList<Worker> workers;
    private Season season;

    public Player (String name){
        pointTokens = 0;
        resources = new TreeMap<>();
        resources.put(Resource.BERRIES, 0);
        resources.put(Resource.RESIN, 0);
        resources.put(Resource.STONES, 0);
        resources.put(Resource.TWIGS, 0);
        this.name = name;
        hand = new ArrayList<>();
        board = new ArrayList<>();
        completedEvents = new ArrayList<>();
        workers = new ArrayList<>();
        workers.add(new Worker(this));
        workers.add(new Worker(this));
        season = Season.WINTER;
        playedNonBoardCards = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public boolean hasAvailableWorker (){
        for (Worker worker : workers) {
            if (worker.isAvailable()){
                return true;
            }
        }
        return false;
    }
    public void gainResource (Resource resource, int amount){
        resources.put(resource, resources.get(resource) + amount);
    }
    public TreeMap<Resource, Integer> getResources(){
        return resources;
    }
    public void gainPointTokens (int amount){
        pointTokens += amount;
    }
    public int getPointTokens(){
        return pointTokens;
    }
    public Season getSeason(){
        return season;
    }
    public void setSeason(Season season){
        this.season = season;
    }
    public void retrieveWorkers(){
        for (Worker worker : workers) {
            if(worker.canBeReturned()) {
                worker.returnWorker();
            }
        }
    }
    public void gainWorker (){
        workers.add(new Worker(this));
    }
    public ArrayList<Worker> getWorkers(){
        return workers;
    }


    public int getHandSize(){
        return hand.size();
    }
    public Worker nextAvailableWorker (){
        for (Worker worker : workers) {
            if (worker.isAvailable()) {
                return worker;
            }
        }
        return null;
    }
    public void addCard(Card card){
        hand.add(card);
    }
    public int countFarms (){
        int count = 0;
        for (Card card : board) {
            if (card instanceof Farm) {
                count++;
            }
        }
        return count;
    }
    public void addCardToBoard (Card card){
        board.add(card);
    }
    public ArrayList<Card> getBoard(){
        return board;
    }
    public ArrayList<Card> getPlayedNonBoardCards(){
        return playedNonBoardCards;
    }
    public void addNonBoardCard (Card card){
        playedNonBoardCards.add(card);
    }
    public boolean isCardOnBoard (Card card){
        for (Card playedCard : board) {
            if (card.getName().equals(playedCard.getName())) {
                return true;
            }
        }
        return false;
    }
    public void playCritter (Critter critter, Game game){
        Shopkeeper shopkeeper = new Shopkeeper();
        boolean hasShopkeeper = isCardOnBoard(shopkeeper);

        if(hasShopkeeper){
            shopkeeper.ability(this, game);
        }
    }
}
