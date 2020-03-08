import edu.princeton.cs.introcs.StdOut;


public class SkunkApp
{

	public static void main(String args[]) 
	{
		Dice dice = new Dice();
		
		StdOut.println("Welcome to SkunkApp! Let's get started.");
		dice.roll();
		StdOut.println(dice);
	}
}
