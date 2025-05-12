package TestBasicLocations;

import Everdell.Locations.BasicLocation.BerryAndCard;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBerryAndCard {
    private BerryAndCard berryAndCard;
    private Game game ;
    private Player player ;
    @Before
    public void setUp() {
        berryAndCard = new BerryAndCard();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testVisit(){
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES));
        assertEquals(0, player.getHandSize());

        berryAndCard.visit(player, game);
        assertEquals(1, (int) player.getResources().get(Resource.BERRIES));
        assertEquals(1, player.getHandSize());
    }

    @Test
    public void canVisit(){
        assertTrue(berryAndCard.canVisit(player));
        game.visitLocation(player, berryAndCard);
        assertFalse(berryAndCard.canVisit(player));
    }
}
