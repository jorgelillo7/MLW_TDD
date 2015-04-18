package klondike;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MoveTableauToFoundationControllerTest {

	private MoveTableauToFoundationController moveTableauToFoundationController;
	private StartGameController startGameController; 

	private final static int FOUNDATION_POSITION_NUMBER = 3;
	private static final int TABLEAU_NUMBER = 1;

	@Before
	public void before() {
		startGameController = new StartGameController();
		moveTableauToFoundationController = new MoveTableauToFoundationController(startGameController);
	}
	 
	@Test
	public void moveTest(){ 
		Card heartOne = new Card(1, 1); 
		Card heartTwo = new Card(2, 1); 
		Card heartThree = new Card(3, 1); 
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER, heartOne);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER, heartTwo);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER, heartThree);
		
		startGameController.addCardToTableau(TABLEAU_NUMBER, new Card(4,
				1));
       
		moveTableauToFoundationController.move(FOUNDATION_POSITION_NUMBER, TABLEAU_NUMBER);
        assertEquals(0, startGameController.getTableau(TABLEAU_NUMBER).size());
        assertEquals(4, startGameController.getFoundation(FOUNDATION_POSITION_NUMBER).size());
       
	}
	
	@Test
	public void moveBadMovementTest(){
		Card heartOne = new Card(1, 1); 
		Card heartTwo = new Card(2, 1); 
		Card heartThree = new Card(3, 1); 
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER, heartOne);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER, heartTwo);
		startGameController.addCardToFundation(FOUNDATION_POSITION_NUMBER, heartThree);
		
		startGameController.addCardToTableau(TABLEAU_NUMBER, new Card(5,
				2));
       
		moveTableauToFoundationController.move(FOUNDATION_POSITION_NUMBER, TABLEAU_NUMBER);
        assertEquals(1, startGameController.getTableau(TABLEAU_NUMBER).size());
        assertEquals(3, startGameController.getFoundation(FOUNDATION_POSITION_NUMBER).size());
       
		
	}

}
