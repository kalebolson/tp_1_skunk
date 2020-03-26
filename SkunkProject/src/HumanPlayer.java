import java.util.Scanner;

public class HumanPlayer {
	public String HumanPlayerName;
	
	public Scanner Input = new Scanner (System.in);
	
	/*Setter method for human player name 
	 * The two methods below will help set the player's name to whatever is entered on the keyboard
	 */
	
	public HumanPlayer() {
		
		setPlayerName(Input);
		
	}
	
	private void setPlayerName(Scanner input) {
		// TODO Auto-generated method stub
		this.HumanPlayerName = Input.toString();
	}

	// getter method to return the name of the player 
	public String getPlayerName() {
		return HumanPlayerName;
	}	
	
	
	 // This method is to get the entered player's name 
	 
	public void getHumanPlayerName() {
		System.out.println("Please, enter the player's name: ");

		if (Input.hasNext()) {
			if((Input != null) && (!Input.equals(""))) {
				setPlayerName(Input);
			}			
		}			
	} 

}
