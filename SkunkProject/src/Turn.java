
public class Turn
{
	private HumanPlayer player;
	private int currentScore = 0;
	
	
	public Turn(HumanPlayer p)
	{
		this.player = p;
	}
	
	public void updateScore(int num)
	{
		currentScore+=num;
	}
	
	public void clearScore() 
	{
		currentScore=0;
	}
	
	public int getScore() 
	{
		return currentScore;
	}
	
	public void endTurn() 
	{
		player.addPoints(currentScore);
	}
}
