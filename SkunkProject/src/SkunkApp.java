import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class SkunkApp
{
	static Game game;

	public static void main(String args[]) 
	{
		String[] names;
		Boolean running = true;
		String input;
		
		StdOut.println("Welcome to SkunkApp! Let's get started.");
		StdOut.println("Enter the unique first name of each player, separated by spaces.");
		String nameString = StdIn.readLine();
		names = nameString.split(" ",0);
		
		game = new Game(names);
		game.startTurn();
		
		StdOut.println("Great! Looks like our first player is "+game.getCurrentPlayer().getPlayerName()+".");
		
		//This is the main game loop
		while (running)
		{
			StdOut.println("\n\n"+game.getCurrentPlayer().getPlayerName()+", what would you like to do?");
			StdOut.println("'r' to Roll Dice \n"
					+ "'e' to End Turn \n"
					+ "'q' to Quit Game");
			input = StdIn.readLine().toLowerCase();
			
			switch(input)
			{
				case ("r"):
					roll();
					break;
					
				case ("e"):
					endTurn();
					if (game.isOver())
					{
						endGame();
						running = false;
					}
					break;
					
				case ("q"):
					running = quitGame();
					break;
					
				default:
					StdOut.println("Invalid character");
					break;
			}
		}
		StdOut.println("\n\nGoodbye!");
	}
	
	public static void roll()
	{
		game.roll();
		StdOut.println("\n"+game.getRoll()+"\n");
		//displaying the player's current score plus the score of the turn
		StdOut.println("Current Score: "+(game.getCurrentPlayer().getPoints()+game.getTurnScore()));
		StdOut.println();
		
		if (game.isDeuce()||game.isSkunk())
			endTurn();
			
	}
	
	public static void endTurn()
	{
		game.endTurn();
		StdOut.println("Summary: \n"+game.getCurrentPlayer());
		
		game.setNextPlayer();
		game.startTurn();
		if (!game.isOver())
			StdOut.println("\n"+game.getCurrentPlayer().getPlayerName()+" is up next!");
	}
	
	public static Boolean quitGame()
	{
		StdOut.println("Are you certain you want to quit the game? y/n");
		String input = StdIn.readLine().toLowerCase();
		
		if (input.contentEquals("y"))
			return false;
		else
			return true;
	}
	
	public static void endGame()
	{
		StdOut.println("\n\nThat's game! Let's view the results: \n"
				+ game.results());
	}
}
