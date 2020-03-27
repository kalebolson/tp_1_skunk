import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TurnTest {
	@Test
public void getScore() {
		
		Turn t = new Turn(null);
		t.currentScore = 15;
		 assertEquals(t.getScore(), 15);
		
}
}
	
