
public class TrickDie extends Die
{
	public TrickDie(int num) 
	{
		this.setLastRoll(num);
	}
	
	public void roll(int num) 
	{
		this.setLastRoll(num);
	}
}
