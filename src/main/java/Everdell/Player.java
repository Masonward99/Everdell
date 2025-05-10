package Everdell;

import Everdell.Cards.AbilityCard;
import Everdell.Cards.BlueGovernance.Courthouse;
import Everdell.Cards.BlueGovernance.Historian;
import Everdell.Cards.BlueGovernance.Shopkeeper;
import Everdell.Cards.Card;
import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.TanTraveller.Wanderer;
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

    public ArrayList<Event> getCompletedEvents() {return completedEvents;}
    public void addEvent(Event event){completedEvents.add(event);}
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
        // Activate ability if tan traveller or production
        if (critter instanceof AbilityCard)  ((AbilityCard) critter).action(this, game);
        //Add Critter to correct list
        if (critter instanceof Wanderer)  addNonBoardCard((Wanderer) critter);
        else addCardToBoard((Card) critter);
        //activate shopkeeper
        if(hasShopkeeper) shopkeeper.ability(this, game);
    }
    public void playConstruction (Construction construction, Game game){
        Courthouse courthouse = new Courthouse();
        boolean hasCourthouse = isCardOnBoard(courthouse);
        //Activate ability for ability cards
        if(construction instanceof AbilityCard)  ((AbilityCard) construction).action(this, game);
        // add card to board
        addCardToBoard((Card) construction);
        //activate courthouse
        if(hasCourthouse) courthouse.ability(this, game);
    }
    public void playCard (Card card, Game game){
        Historian historian = new Historian();
        boolean hasHistorian = isCardOnBoard(historian);
        if(card instanceof Critter) playCritter((Critter) card, game);
        else if(card instanceof Construction) playConstruction((Construction) card, game);
        if(hasHistorian) historian.ability(this, game);
    }
    public void spendResources (TreeMap<Resource, Integer> resources){
        for (Resource resource : resources.keySet()) this.resources.put(resource, this.resources.get(resource) - resources.get(resource));
    }
}
