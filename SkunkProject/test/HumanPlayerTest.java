import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HumanPlayerTest {

	
	@Test
    public void testToString()
   
    {
		
        HumanPlayer p = new HumanPlayer("Jake");
  
        p.setPlayerName("Jake");
        p.setPoints(30);
        p.addChips(5);
        
      
        assertEquals("Player: "+Jake+"\n\""
        		+ "Score: "+30+"\n\""
        				+ "Chips: "+5+""); p.toString();
    }

	
}
