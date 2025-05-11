import Everdell.Cards.BlueGovernance.Courthouse;
import Everdell.Cards.BlueGovernance.Shopkeeper;
import Everdell.Cards.Production.Fairgrounds;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.Production.Production;
import Everdell.Cards.Prosperity.Architect;
import Everdell.Cards.Prosperity.Castle;
import Everdell.Cards.Prosperity.EverTree;
import Everdell.Cards.Prosperity.Palace;
import Everdell.Cards.TanTraveller.Wanderer;
import Everdell.Deck;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class TestPlayer {
    private Player player;
    private Deck deck;
    private Game game;

    @Before
    public void setUp() {
        player = new Player("Steve");
        deck = new Deck();
        game = new Game(0);
    }
    @Test
    public void testCountFarms(){
        assertEquals(0, player.countFarms());
        player.addCardToBoard(new Farm());
        assertEquals(1, player.countFarms());
        player.addCardToBoard(new Farm());
        player.addCardToBoard(new Farm());
        assertEquals(3, player.countFarms());
    }

    @Test
    public void testSpendResources (){
        player.gainResource(Resource.TWIGS, 3);
        player.gainResource(Resource.RESIN, 2);
        assertEquals(3, (int)player.getResources().get(Resource.TWIGS));
        assertEquals(2, (int)player.getResources().get(Resource.RESIN));
        player.spendResources(new Farm().getCosts());
        assertEquals(1, (int)player.getResources().get(Resource.TWIGS));
        assertEquals(1, (int)player.getResources().get(Resource.RESIN));
    }
    @Test
    public void testSpendResourcesWithBerries(){
        player.gainResource(Resource.BERRIES, 8);
        player.spendResources(new Architect().getCosts());
        assertEquals(4, (int)player.getResources().get(Resource.BERRIES));
    }
    @Test
    public void testSpendResourcesWithCastle(){
        player.gainResource(Resource.TWIGS, 5);
        player.gainResource(Resource.RESIN, 4);
        player.gainResource(Resource.BERRIES, 5);
        player.gainResource(Resource.STONES, 3 );
        player.spendResources(new Castle().getCosts());
        assertEquals(5, (int)player.getResources().get(Resource.BERRIES));
        assertEquals(1, (int)player.getResources().get(Resource.RESIN));
        assertEquals(0, (int)player.getResources().get(Resource.STONES));
        assertEquals(3, (int)player.getResources().get(Resource.TWIGS));
    }

    @Test
    public void testPlayCritterPlayingShopkeeper(){
        Shopkeeper shopkeeper = new Shopkeeper();
        assertFalse(player.getBoard().contains(shopkeeper));
        player.playCritter(shopkeeper, game);
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES));
        assertTrue(player.getBoard().contains(shopkeeper));
    }
    @Test
    public void testPlayCritterWithShopkeeperInPlay(){
        Shopkeeper shopkeeper = new Shopkeeper();
        player.playCritter(shopkeeper, game);
        Architect architect = new Architect();
        player.playCritter(architect, game);
        //player gains berry
        assertEquals(1, (int) player.getResources().get(Resource.BERRIES));
        //architect in correct position
        assert(player.getBoard().get(1) == architect);
    }

    @Test
    public void testPlayCritterWithWanderer(){
        Wanderer wanderer = new Wanderer();
        assertEquals(0, player.getHandSize());
        player.playCritter(wanderer, game);
        //wanderer played in correct board
        assertFalse(player.getBoard().contains(wanderer));
        assertTrue(player.getPlayedNonBoardCards().contains(wanderer));
        assertEquals(3, player.getHandSize());
        //does not gain berry
        assertEquals(0, (int)player.getResources().get(Resource.BERRIES));
    }

    @Test
    public void testPlayConstruction(){
        Farm farm = new Farm();
        assertEquals(0, player.getHandSize());
        assertEquals(0, (int)player.getResources().get(Resource.BERRIES));
        player.playConstruction(farm, game);
        assertEquals(0, player.getHandSize());
        assertTrue(player.getBoard().contains(farm));
        assertEquals(1, (int)player.getResources().get(Resource.BERRIES));
    }
    @Test
    public void testPlayConstructionPlayingCourthouse(){
        String inputStream = "0\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(inputStream.getBytes());
        System.setIn(bais);
        game = new Game(0);

        Courthouse courthouse = new Courthouse();
        assertEquals(0, (int)player.getResources().get(Resource.TWIGS));
        player.playConstruction(courthouse, game);
        assertEquals(0, (int)player.getResources().get(Resource.TWIGS));
        assertTrue(player.getBoard().contains(courthouse));
    }
    @Test
    public void testPlayConstructionWithCourthouseInPlay(){
        String inputStream = "0\n2\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(inputStream.getBytes());
        System.setIn(bais);
        game = new Game(0);

        Courthouse courthouse = new Courthouse();
        player.playConstruction(courthouse, game);
        assertEquals(0, (int)player.getResources().get(Resource.TWIGS) );
        player.playConstruction(new Castle(), game);
        assertEquals(1, (int)player.getResources().get(Resource.TWIGS) );

        player.playConstruction(new Palace(), game);
        assertEquals(1, (int)player.getResources().get(Resource.STONES) );
    }
    @Test
    public void testPlayConstructionWithProduction(){
        assertEquals(0, player.getHandSize());
        player.playConstruction(new Fairgrounds(), game);
        assertEquals(2, player.getHandSize());
    }

    @Test
    public void testHasEnoughResources(){
        //works with discount
        assertTrue(player.hasEnoughResources(new Farm().getCosts(), 3));
        assertFalse(player.hasEnoughResources(new Farm().getCosts(), 2));
        //works without discount
        player.gainResource(Resource.TWIGS,2);
        player.gainResource(Resource.RESIN,1);
        assertTrue(player.hasEnoughResources(new Farm().getCosts(), 0));
        assertFalse(player.hasEnoughResources(new Castle().getCosts(), 1));
    }

}
