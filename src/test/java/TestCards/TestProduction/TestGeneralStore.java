package TestCards.TestProduction;

import Everdell.Cards.Production.Farm;
import Everdell.Cards.Production.GeneralStore;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGeneralStore {
    GeneralStore generalStore;
    Player player;
    Game game;
    @Before
    public void setUp() {
        generalStore = new GeneralStore();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testGeneralStore() {
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES));
        generalStore.action(player, game);
        assertEquals(1, (int) player.getResources().get(Resource.BERRIES));
        // has farm
        player.addCardToBoard(new Farm());
        generalStore.action(player, game);
        assertEquals(3, (int) player.getResources().get(Resource.BERRIES));
        //has multiple farms
        player.addCardToBoard(new Farm());
        generalStore.action(player, game);
        assertEquals(5, (int) player.getResources().get(Resource.BERRIES));
    }
}
