
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
	
	@Override
	public void roll()
	{
		//we want this to do nothing,
		//rolling a trick die shouldn't change the face
		this.setLastRoll(lastRoll);
	}
}
