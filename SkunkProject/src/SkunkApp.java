import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdOut;


public class SkunkApp
{

	public static void main(String args[]) 
	{
		Game game;
		Scanner sc = new Scanner(System.in);
		String[] names;
		Boolean running = true;
		String input;
		
		StdOut.println("Welcome to SkunkApp! Let's get started.");
		StdOut.println("Enter the unique first name of each player, separated by spaces.");
		String nameString = sc.nextLine();
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
			input = sc.nextLine().toLowerCase();
			
			switch(input)
			{
				case ("r"):
					roll(game);
					break;
					
				case ("e"):
					endTurn(game);
					break;
					
				case ("q"):
					running = endGame();
				
				default:
					StdOut.println("Invalid character");
			}
		}
	}
	
	public static void roll(Game game)
	{
		game.roll();
		StdOut.println(game.getRoll());
		StdOut.println("Current Score: "+(game.getCurrentPlayer().getPoints()+game.getTurnScore()));
		StdOut.println();
		
		if (game.isDeuce()||game.isSkunk())
			endTurn(game);
			
	}
	
	public static void endTurn(Game game)
	{
		game.endTurn();
		StdOut.println("Summary: \n"+game.getCurrentPlayer());
		
		game.setNextPlayer();
		game.startTurn();
		StdOut.println(game.getCurrentPlayer().getPlayerName()+" is up next!");
	}
	
	public static Boolean endGame()
	{
		Scanner sc = new Scanner(System.in);
		StdOut.println("Are you certain you want to quit the game? y/n");
		String input = sc.nextLine().toLowerCase();
		
		if (input == "y")
			return false;
		else
			return true;
	}
}
