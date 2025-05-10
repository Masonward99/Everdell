package TestCards.TestBlueGovernance;

import Everdell.Cards.BlueGovernance.Historian;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHistorian {
    private Historian historian;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        historian = new Historian();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testHistorianAbility() {
        assertEquals(0, player.getHandSize());
        historian.ability(player, game);
        assertEquals(1, player.getHandSize());
        historian.ability(player, game);
        historian.ability(player, game);
        assertEquals(3, player.getHandSize());
    }
}
