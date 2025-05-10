import Everdell.Cards.Production.Farm;
import Everdell.Deck;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlayer {
    private Player player;
    private Deck deck;

    @Before
    public void setUp() {
        player = new Player("Steve");
        deck = new Deck();
    }
    @Test
    public void testCountFarms(){
        assertEquals(0, player.countFarms());
        player.addCardToBoard(new Farm());
        assertEquals(1, player.countFarms());
        player.addCardToBoard(new Farm());
        player.addCardToBoard(new Farm());
        assertEquals(3, player.countFarms());
    }

}
