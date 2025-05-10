package TestCards.TestProsperity;

import Everdell.Cards.Production.Fairgrounds;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.Production.GeneralStore;
import Everdell.Cards.Production.Mine;
import Everdell.Cards.Prosperity.Castle;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCastle {
    private Castle castle;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        castle = new Castle();
        player = new Player("Steve");
        game = new Game(0);
    }
    @Test
    public void testBonus() {
        assertEquals(castle.bonusPoints(player), 0);
        player.addCardToBoard(new Farm());
        player.addCardToBoard(new GeneralStore());
        player.addCardToBoard(new Mine());
        //counts common constructions
        assertEquals(castle.bonusPoints(player), 3);

        //does not count unique constructions
        player.addCardToBoard(new Fairgrounds());
        player.addCardToBoard(new Castle());
        assertEquals(castle.bonusPoints(player), 3);

    }
}
