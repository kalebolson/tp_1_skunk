import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TurnTest 
{
	
	@Test
	public void test_update_score() 
	{		
		Turn t = new Turn(null);
		t.updateScore(15);
		 assertEquals(t.getScore(), 15);
	}
	
	@Test
	public void test_clear_score()
	{
		Turn t = new Turn(null);
		t.updateScore(20);
		t.clearScore();
		assertEquals(t.getScore(), 0);
	}
	
	@Test
	public void test_end_turn()
	{
		HumanPlayer p = new HumanPlayer("John");
		Turn t = new Turn(p);
		t.updateScore(13);
		t.endTurn();
		assertEquals(p.getPoints(),13);
	}
	
	
}
	
