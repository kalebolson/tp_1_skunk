import java.util.ArrayList;

//Game is our controller class, it will interface with the UI
public class Game
{
	HumanPlayer[] players;
	int currentPlayerIndex;
	Turn currentTurn;
	Dice dice = new Dice();
	Boolean lastRound = false;
	int lastRoundCounter;
	Boolean isOver = false;
	
	
	public Game(String[] names)
	{
		players = new HumanPlayer[names.length];
		for (int i=0; i<names.length; i++)
		{
			players[i] = new HumanPlayer(names[i]);
		}
		lastRoundCounter = players.length-1;
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
		currentTurn.endTurn(); //This adds the Turn's points to the player's points
		currentTurn = null;
		
		//Checking to see if we should start the last round, provided
		//it is not already the last round
		if (getCurrentPlayer().getPoints() >= 100 && !lastRound)
		{
			lastRound = true;
		}
		
		//During the last round, there is a counter equal to the number of players
		//this counter will decrease by 1 each turn until it hits 0.
		//Once it hits 0, the boolean isOver becomes true.
		//The UI checks every turn to see if isOver is true, and responds appropriately.
		if (lastRound)
		{
			lastRoundCounter--;
			if (lastRoundCounter == 0)
			{
				isOver = true;
			}
		}
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
	
	public Boolean isOver()
	{
		return isOver;
	}
	
	public String results()
	{
		String results = "";
		HumanPlayer winner = players[0];
		for (HumanPlayer p : players)
		{
			results += p.getPlayerName() + ": " + p.getPoints() + "\n";
			if (p.getPoints() > winner.getPoints())
				winner = p;
		}
		results += "\nThe winner is: " + winner.getPlayerName();
		return results;
	}
	
	//This method is only for testing purposes
	public void testDice(int face1, int face2)
	{
		TrickDie d1 = new TrickDie(face1);
		TrickDie d2 = new TrickDie(face2);
		dice = new Dice(d1,d2);
	}
}
