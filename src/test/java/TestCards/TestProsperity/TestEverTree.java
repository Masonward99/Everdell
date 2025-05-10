package TestCards.TestProsperity;

import Everdell.Cards.Production.BargeToad;
import Everdell.Cards.Prosperity.EverTree;
import Everdell.Cards.TanTraveller.Wanderer;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestEverTree {
    private EverTree everTree;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        everTree = new EverTree();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testBonus() {
        assertEquals(0, everTree.bonusPoints(player));
        // 1 prosperity card
        player.addCardToBoard(new EverTree());
        assertEquals(1, everTree.bonusPoints(player));
        // 3 prosperity cards
        player.addCardToBoard(new EverTree());
        player.addCardToBoard(new EverTree());
        assertEquals(3, everTree.bonusPoints(player));
    }
    @Test
    public void testCanBeOccupied (){
        //not occupied
        assertTrue(everTree.canBeOccupiedBy(new BargeToad()));
        assertTrue(everTree.canBeOccupiedBy(new Wanderer()));

        everTree.setOccupied();
        //occupied
        assertFalse(everTree.canBeOccupiedBy(new BargeToad()));
        assertFalse(everTree.canBeOccupiedBy(new Wanderer()));

    }
}
