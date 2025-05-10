package TestCards.TestProduction;

import Everdell.Cards.Production.BargeToad;
import Everdell.Cards.Production.Farm;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBargeToad {
    BargeToad bargeToad;
    Player player;
    Game game;
    @Before
    public void setUp() {
        bargeToad = new BargeToad();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testBargeToad() {
        assertEquals(0, (int) player.getResources().get(Resource.TWIGS));
        bargeToad.action(player, game);
        // city has no farms
        assertEquals(0, (int) player.getResources().get(Resource.TWIGS));
        //city has one farm
        player.addCardToBoard(new Farm());
        bargeToad.action(player, game);
        assertEquals(2, (int) player.getResources().get(Resource.TWIGS));
        // city with 3 farms
        player.addCardToBoard(new Farm());
        player.addCardToBoard(new Farm());
        bargeToad.action(player, game);
        assertEquals(8, (int) player.getResources().get(Resource.TWIGS));
    }
}
