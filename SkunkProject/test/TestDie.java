import static org.junit.Assert.*;

import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

public class TestDie
{

	@Test
	public void test_testable_roll()
	{
		TrickDie die = new TrickDie(4);
		assertEquals(die.getLastRoll(),4);
	}
	
	@Test
	//due to the randomization factor of roll(), I am running the assertTrue statement three
	//times more than the number of potential results
	public void test_roll_range() 
	{
		Die die = new Die();
		for (int i=0; i<18; i++)
		{
			die.roll();
			assertTrue( 0 < die.getLastRoll() && die.getLastRoll() <= 6);
		}
	}
}
