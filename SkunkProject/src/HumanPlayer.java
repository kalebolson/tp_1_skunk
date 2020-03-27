import java.util.Scanner;

public class HumanPlayer {
	private String name;
	private int points = 0;
	private int chips = 0;
	
	public HumanPlayer(String name) {		
		setPlayerName(name);
	}
	
	public void setPlayerName(String name) {
		this.name = name;
	}
	
	// getter method to return the name of the player 
	public String getPlayerName() {
		return name;
	}	
	
	public void addPoints(int num) {
		this.points += num;
	}
	
	public void subtractPoints(int num) {
		this.points -= num;
	}
	
	public void clearPoints()
	{
		this.points = 0;
	}
	
	public void setPoints(int num) {
		this.points = num;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addChip() {
		chips++;
	}
	
	public void addChips(int num) {
		chips += num;
	}
	
	public void removeChips(int num) {
		chips -= num;
	}
	
	public int getChips() {
		return chips;
	}
	
	public String toString()
	{
		String s = ("Player: "+name+"\n"
				+ "Score: "+points+"\n"
				+ "Chips: "+chips);
		return s;
	}
}
