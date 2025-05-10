package TestCards.TestProsperity;

import Everdell.Cards.Prosperity.Architect;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArchitect {
    private Architect architect;
    private Player player;
    @Before
    public void setUp() {
        architect = new Architect();
        player = new Player("Steve");
    }
    @Test
    public void testArchitect() {
        assertEquals(0, architect.bonusPoints(player));
        player.gainResource(Resource.STONES, 2);
        assertEquals(2, architect.bonusPoints(player));
        player.gainResource(Resource.BERRIES, 2);
        assertEquals(2, architect.bonusPoints(player));
        player.gainResource(Resource.TWIGS, 2);
        assertEquals(2, architect.bonusPoints(player));
        player.gainResource(Resource.STONES, 2);
        assertEquals(4, architect.bonusPoints(player));
        player.gainResource(Resource.RESIN, 3);
        assertEquals(6, architect.bonusPoints(player));
    }
}
