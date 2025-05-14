package Everdell;

import Everdell.Cards.BlueGovernance.ClockTower;
import Everdell.Cards.BlueGovernance.Courthouse;
import Everdell.Cards.BlueGovernance.Historian;
import Everdell.Cards.BlueGovernance.Shopkeeper;
import Everdell.Cards.Card;
import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.Production.Production;
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
    private boolean hasFinished;

    //constructor
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
        hasFinished = false;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public TreeMap<Resource, Integer> getResources(){
        return resources;
    }

    public int getPointTokens(){
        return pointTokens;
    }

    public void setSeason(Season season){
        this.season = season;
    }

    public ArrayList<Worker> getWorkers(){
        return workers;
    }

    public ArrayList<Card> getBoard(){
        return board;
    }

    public ArrayList<Card> getPlayedNonBoardCards(){
        return playedNonBoardCards;
    }

    public ArrayList<Event> getCompletedEvents() {return completedEvents;}

    public int getHandSize(){
        return hand.size();
    }

    public ArrayList<Card> getHand(){ return hand; }

    public ArrayList<Card> getProductions(){
        ArrayList<Card> productions = new ArrayList<>();
        for (Card card : board) {
            if (card instanceof Production) productions.add(card);
        }
        return productions;
    }

    public boolean hasFinished(){return hasFinished;}

    //workers

    public void retrieveWorkers(){
        for (Worker worker : workers) {
            if(worker.canBeReturned()) {
                worker.returnWorker();
            }
        }
    }

    public boolean hasAvailableWorker (){
        for (Worker worker : workers) {
            if (worker.isAvailable()){
                return true;
            }
        }
        return false;
    }

    public void gainWorker (){
        workers.add(new Worker(this));
    }

    public Worker nextAvailableWorker (){
        for (Worker worker : workers) {
            if (worker.isAvailable()) {
                return worker;
            }
        }
        return null;
    }

    public ArrayList<Worker> getRedeployableWorkers(){
        ArrayList<Worker> redeployableWorkers = new ArrayList<>();
        for (Worker worker : workers) {
            if(!worker.isAvailable() && worker.canBeReturned()) redeployableWorkers.add(worker);
        }
        return redeployableWorkers;
    }

    //resources
    public void gainResource (Resource resource, int amount){
        resources.put(resource, resources.get(resource) + amount);
    }

    public void gainPointTokens (int amount){
        pointTokens += amount;
    }

    public void gainResources (TreeMap<Resource, Integer> resources){
        for (Resource resource : resources.keySet()) {
            this.resources.put(resource, this.resources.get(resource) + resources.get(resource));
        }
    }

    public void spendResources (TreeMap<Resource, Integer> resources){
        for (Resource resource : resources.keySet()) this.resources.put(resource, this.resources.get(resource) - resources.get(resource));
    }

    public boolean hasEnoughResources (TreeMap<Resource, Integer> resources, int discount){
        for (Resource resource : resources.keySet()) {
            int difference = this.resources.get(resource) - resources.get(resource);
            if (difference < 0) discount += difference;
        }
        return discount >= 0;
    }

    public int totalResources (){
        int count = 0;
        for (Resource resource : resources.keySet()) {count += resources.get(resource);}
        return count;
    }

    public ArrayList<Resource> getNonZeroResources(){
        ArrayList<Resource> decidableResources = new ArrayList<>();
        for (Resource resource : resources.keySet()) {if (resources.get(resource) >0) decidableResources.add(resource);}
        return decidableResources;
    }

    //Events
    public void addEvent(Event event){completedEvents.add(event);}

    //Cards

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

    public boolean isCardOnBoard (Card card){
        for (Card playedCard : board) {
            if (card.getName().equals(playedCard.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean canOccupyBoard(Critter critter){
        for (Card card : board) {
            if(card instanceof Construction && ((Construction)card).canBeOccupiedBy(critter)) return true;
        }
        return false;
    }

    public void removeCardFromHand (Card card){hand.remove(card);}

    public void removeCardFromBoard (Card card){board.remove(card);}

    //Card playing

    public void addCardToBoard (Card card){
        board.add(card);
    }

    public void addNonBoardCard (Card card){
        playedNonBoardCards.add(card);
    }

    public void playCritter (Critter critter, Game game){
        Shopkeeper shopkeeper = new Shopkeeper();
        boolean hasShopkeeper = isCardOnBoard(shopkeeper);
        critter.playCard(this, game);
        if(hasShopkeeper) shopkeeper.ability(this, game);
    }

    public void playConstruction (Construction construction, Game game){
        Courthouse courthouse = new Courthouse();
        boolean hasCourthouse = isCardOnBoard(courthouse);
        construction.playCard(this, game);
        if(hasCourthouse) courthouse.ability(this, game);
    }

    public void playCard (Card card, Game game){
        Historian historian = new Historian();
        boolean hasHistorian = isCardOnBoard(historian);
        if(card instanceof Critter) playCritter((Critter) card, game);
        else if(card instanceof Construction) playConstruction((Construction) card, game);
        if(hasHistorian) historian.ability(this, game);
    }

    public void prepareForSeason (Game game){
        if(isCardOnBoard(new ClockTower()) && season != Season.SUMMER) {
            ClockTower clockTower = ((ClockTower) getCardOnBoard(new ClockTower()));
            clockTower.ability(this, game);
        }
        retrieveWorkers();
        switch (season){
            case WINTER -> {
                gainWorker();
                activateProductions(game);
                setSeason(Season.WINTER);
            }
            case SPRING -> {
                gainWorker();
                game.drawFromMeadow(this);
                game.drawFromMeadow(this);
                game.refillMeadow();
                setSeason(Season.SPRING);
            }
            case SUMMER -> {
                gainWorker();
                gainWorker();
                activateProductions(game);
                setSeason(Season.AUTUMN);
            }
            case AUTUMN -> {
                //when finished no cards can be added to your board. Game ends when all players have finished.
                hasFinished = true;
            }
        }

    }

    private void activateProductions (Game game){
        for (Card card : board) {
            if (card instanceof Production) ((Production) card).action(this, game);
        }
    }

    public Card getCardOnBoard (Card card){
        for (Card playedCard : board) {
            if (playedCard.getName().equals(card.getName())) return playedCard;
        }
        return null;
    }
}
