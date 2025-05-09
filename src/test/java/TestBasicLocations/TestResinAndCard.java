package TestBasicLocations;

import Everdell.BasicLocation.ResinAndCard;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestResinAndCard {
    private ResinAndCard resinAndCard;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        resinAndCard = new ResinAndCard();
        game = new Game(0);
        player = new Player("phil");
    }
    @Test
    public void testResinAndCard() {
        assertEquals(0,player.getHandSize());
        assertEquals(0, (int) player.getResources().get(Resource.RESIN));

        resinAndCard.visit(player.nextAvailableWorker(), game);
        assertEquals(1,player.getHandSize());
        assertEquals(1,(int) player.getResources().get(Resource.RESIN));

        resinAndCard.visit(player.nextAvailableWorker(), game);
        assertEquals(2,player.getHandSize());
        assertEquals(2,(int) player.getResources().get(Resource.RESIN));
    }
}
