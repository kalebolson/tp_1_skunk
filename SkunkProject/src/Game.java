import java.util.ArrayList;

//Game is our controller class, it will interface with the UI
public class Game
{
	HumanPlayer[] players;
	int currentPlayerIndex;
	Turn currentTurn;
	Dice dice = new Dice();
	
	
	public Game(String[] names)
	{
		players = new HumanPlayer[names.length];
		for (int i=0; i<names.length; i++)
		{
			players[i] = new HumanPlayer(names[i]);
		}
	}
	
	public void setNextPlayer()
	{
		currentPlayerIndex = ((currentPlayerIndex+1) % (players.length));
	}
	
	public void startTurn()
	{
		currentTurn = new Turn(players[currentPlayerIndex]);
	}
	
	public void roll()
	{
		dice.roll();
		
		if (dice.isSkunk())
		{
			currentTurn.clearScore();
			if (dice.isDeuce())
				players[currentPlayerIndex].clearPoints();
			
		}
		else 
		{
			//updating the score of this turn
			currentTurn.updateScore(dice.getLastRoll());
		}
	}
	
	public String getRoll()
	{
		return dice.toString();
	}
	
	
	public void endTurn()
	{
		currentTurn.endTurn();
		currentTurn = null;
	}
	
	public HumanPlayer getCurrentPlayer()
	{
		return players[currentPlayerIndex];
	}
	
	public int getTurnScore()
	{
		return currentTurn.getScore();
	}
	
	public Boolean isSkunk()
	{
		return dice.isSkunk();
	}
	
	public Boolean isDeuce()
	{
		return dice.isDeuce();
	}
	
	//This method is only for testing purposes
	public void testDice(int face1, int face2)
	{
		TrickDie d1 = new TrickDie(face1);
		TrickDie d2 = new TrickDie(face2);
		dice = new Dice(d1,d2);
	}
}
