package Everdell.Cards;

public abstract class  Construction extends Card {
    private boolean isOccupied;
    public Construction(String name, String ability,boolean isUnique) {
        super(name,ability,isUnique);
        this.isOccupied = false;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied() {
        this.isOccupied = true;
    }
}
