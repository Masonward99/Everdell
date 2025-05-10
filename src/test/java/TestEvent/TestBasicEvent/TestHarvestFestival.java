package TestEvent.TestBasicEvent;

import Everdell.Cards.Destination.Chapel;
import Everdell.Cards.Production.BargeToad;
import Everdell.Cards.Production.Mine;
import Everdell.Events.BasicEvents.HarvestFestival;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestHarvestFestival {
    private HarvestFestival harvestFestival;
    private Player player;
    @Before
    public void setUp() {
        harvestFestival = new HarvestFestival();
        player = new Player("Steve");
    }
    @Test
    public void testHarvestFestival() {
        assertFalse(harvestFestival.canVisit(player.nextAvailableWorker()));
        player.addCardToBoard(new BargeToad());
        player.addCardToBoard(new Mine());
        player.addCardToBoard(new BargeToad());
        assertFalse(harvestFestival.canVisit(player.nextAvailableWorker()));
        player.addCardToBoard(new Chapel());
        assertFalse(harvestFestival.canVisit(player.nextAvailableWorker()));
        player.addCardToBoard(new BargeToad());
        assertTrue(harvestFestival.canVisit(player.nextAvailableWorker()));
    }
}
