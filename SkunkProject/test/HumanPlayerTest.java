import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HumanPlayerTest 
{

	@Test
    public void test_toString()   
    {
        HumanPlayer p = new HumanPlayer("Jake");
        p.setPoints(30);
        p.addChips(5);
        assertEquals(("Player: "+"Jake"+"\n"
        		   + "Score: "+30+"\n"
        		   + "Chips: "+5+""), p.toString());
    }
	
	@Test
	public void test_set_player_name()
	{
		HumanPlayer p = new HumanPlayer("Jake");
		p.setPlayerName("John");
		assertEquals(p.getPlayerName(),"John");
	}
	
	@Test
	public void test_add_points()
	{
		HumanPlayer p = new HumanPlayer("Jake");
		p.addPoints(3);
		p.addPoints(6);
		assertEquals(p.getPoints(), 9);
	}
	
	@Test
	public void test_subtract_points()
	{
		HumanPlayer p = new HumanPlayer("Jake");
		p.addPoints(20);
		p.subtractPoints(7);
		assertEquals(p.getPoints(), 13);
	}
	
	@Test
	public void test_clear_points()
	{
		HumanPlayer p = new HumanPlayer("Jake");
		p.addPoints(36);
		p.clearPoints();
		assertEquals(p.getPoints(), 0);
	}
	
	@Test
	public void test_set_points()
	{
		HumanPlayer p = new HumanPlayer("Jake");
		p.addPoints(45);
		p.setPoints(43);
		assertEquals(p.getPoints(), 43);
	}
	
	@Test
	public void test_add_chip()
	{
		HumanPlayer p = new HumanPlayer("Jake");
		p.addChip();
		p.addChip();
		p.addChip();
		assertEquals(p.getChips(), 3);
	}
	
	@Test
	public void test_add_chips()
	{
		HumanPlayer p = new HumanPlayer("Jake");
		p.addChips(6);
		assertEquals(p.getChips(), 6);
	}
	
	@Test 
	public void test_remove_chips()
	{
		HumanPlayer p = new HumanPlayer("Jake");
		p.addChips(7);
		p.removeChips(4);
		assertEquals(p.getChips(), 3);
	}
}
