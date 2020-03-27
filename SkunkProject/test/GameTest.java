import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameTest
{

	@Test
	public void test_set_next_player()
	{
		String[] names = new String[] {"Abby","Ben","Carl","Dave"};
		Game game = new Game(names);
		
		game.setNextPlayer();
		assertEquals(game.getCurrentPlayer().getPlayerName(), "Ben");
	}
	
	@Test 
	public void test_start_turn()
	{
		String[] names = new String[] {"Abby","Ben","Carl","Dave"};
		Game game = new Game(names);
		
		game.startTurn();
		assertNotNull(game.currentTurn);
	}
	
	@Test 
	public void test_roll()
	{
		String[] names = new String[] {"Abby","Ben","Carl","Dave"};
		Game game = new Game(names);
		
		game.testDice(4, 5);
		game.startTurn();
		
		game.roll();
		assertEquals(game.getTurnScore(), 9);
	}
	
	@Test
	public void test_end_turn()
	{
		String[] names = new String[] {"Abby","Ben","Carl","Dave"};
		Game game = new Game(names);
		game.startTurn();
		game.endTurn();
		assertNull(game.currentTurn);
	}
	
	@Test
	public void test_is_skunk()
	{
		String[] names = new String[] {"Abby","Ben","Carl","Dave"};
		Game game = new Game(names);
		game.testDice(1, 4);;
		game.startTurn();
		assertTrue(game.isSkunk());
	}
	
	@Test
	public void test_is_deuce()
	{
		String[] names = new String[] {"Abby","Ben","Carl","Dave"};
		Game game = new Game(names);
		game.testDice(1, 1);
		game.startTurn();
		assertTrue(game.isDeuce());
	}
	
}
