package TestCards.TestProduction;

import Everdell.Cards.Production.ResinRefinery;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestResinRefinery {
    private ResinRefinery resinRefinery;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        resinRefinery = new ResinRefinery();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testResinRefinery() {
        assertEquals(0, (int) player.getResources().get(Resource.RESIN));
        resinRefinery.action(player, game);
        assertEquals(1, (int) player.getResources().get(Resource.RESIN));
        resinRefinery.action(player, game);
        resinRefinery.action(player, game);
        assertEquals(3, (int) player.getResources().get(Resource.RESIN));
    }
}
