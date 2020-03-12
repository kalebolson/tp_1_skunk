import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDice
{

	//We will be assuming that the '1' side of the die is the skunk value
	@Test
	public void test_skunk()
	{
		TrickDie die1 = new TrickDie(1);
		TrickDie die2 = new TrickDie(2);
		Dice dice = new Dice(die1,die2);
		
		assertTrue(dice.isSkunk());
	}
	
	@Test
	public void test_not_skunk()
	{
		TrickDie die1 = new TrickDie(2);
		TrickDie die2 = new TrickDie(6);
		Dice dice = new Dice(die1,die2);
		
		assertFalse(dice.isSkunk());
	}
	
	@Test
	public void test_deuce() 
	{
		TrickDie die1 = new TrickDie(1);
		TrickDie die2 = new TrickDie(1);
		Dice dice = new Dice(die1,die2);
		
		assertTrue(dice.isDeuce());
	}
	
	@Test
	public void test_not_deuce()
	{
		TrickDie die1 = new TrickDie(6);
		TrickDie die2 = new TrickDie(1);
		Dice dice = new Dice(die1,die2);
		
		assertFalse(dice.isDeuce());
	}

}
