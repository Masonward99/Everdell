package TestCards.TestBlueGovernance;

import Everdell.Cards.BlueGovernance.Shopkeeper;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShopkeeper {
    private Shopkeeper shopkeeper;
    private Player player;
    private Game game;
    @Before
    public void setUp() {
        shopkeeper = new Shopkeeper();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testShopkeeperAbility(){
        assertEquals(0, (int)player.getResources().get(Resource.BERRIES));
        shopkeeper.ability(player, game);
        assertEquals(1, (int)player.getResources().get(Resource.BERRIES));
        shopkeeper.ability(player, game);
        shopkeeper.ability(player, game);
        assertEquals(3, (int)player.getResources().get(Resource.BERRIES));
    }
}
