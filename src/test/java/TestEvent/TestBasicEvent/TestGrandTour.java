package TestEvent.TestBasicEvent;

import Everdell.Cards.Destination.Chapel;
import Everdell.Events.BasicEvents.GrandTour;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestGrandTour {
    private GrandTour grandTour;
    private Player player;
    @Before
    public void setUp() {
        grandTour = new GrandTour();
        player = new Player("Steve");
    }
    @Test
    public void testGrandTour() {
        assertFalse(grandTour.canVisit(player));
        player.addCardToBoard(new Chapel());
        player.addCardToBoard(new Chapel());
        assertFalse(grandTour.canVisit(player));
        player.addCardToBoard(new Chapel());
        assertTrue(grandTour.canVisit(player));
    }
}
