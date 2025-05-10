package TestEvent.TestBasicEvent;

import Everdell.Cards.BlueGovernance.BlueGovernance;
import Everdell.Cards.BlueGovernance.Shopkeeper;
import Everdell.Events.BasicEvents.CityMonument;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCityMonument {
    private CityMonument cityMonument;
    private Player player;
    @Before
    public void setUp() {
        cityMonument = new CityMonument();
        player = new Player("Steve");
    }
    @Test
    public void testCityMonument() {
        assertFalse(cityMonument.canVisit(player.nextAvailableWorker()));
        player.addCardToBoard(new Shopkeeper());
        player.addCardToBoard(new Shopkeeper());
        assertFalse(cityMonument.canVisit(player.nextAvailableWorker()));
        player.addCardToBoard(new Shopkeeper());
        assertTrue(cityMonument.canVisit(player.nextAvailableWorker()));
    }
}
