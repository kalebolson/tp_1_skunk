
public class Die
{
	int lastRoll;

	public Die()
	{
		this.roll();
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}
	
	public void setLastRoll(int num)
	{
		this.lastRoll = num;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}
	
	public String toString()
	{
		return ("Die: " + this.lastRoll);
	}
}




