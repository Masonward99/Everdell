package TestCards.TestProduction;

import Everdell.Cards.Production.Mine;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestMine {
   private Mine mine ;
   private Game game;
   private Player player;
   @Before
    public void setUp() {
       mine = new Mine();
       player = new Player("Steve");
       game = new Game(0);
   }

   @Test
    public void testMine() {
       assertEquals(0,(int) player.getResources().get(Resource.STONES));
       mine.action(player, game);
       assertEquals(1,(int) player.getResources().get(Resource.STONES));
       mine.action(player, game);
       mine.action(player, game);
       assertEquals(3,(int) player.getResources().get(Resource.STONES));
   }

}
