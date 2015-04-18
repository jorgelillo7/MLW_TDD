package controllers;

import static org.junit.Assert.*;

import java.util.Stack;

import models.Card;

import org.junit.Before;
import org.junit.Test;

import controllers.MoveTableauToFoundationController;
import controllers.StartGameController;

public class MoveTableauToTableauControllerTest {

	private MoveTableauToTableauController moveTableauToTableauController;
	private StartGameController startGameController; 

	private static final int TABLEAU_NUMBER_ORIGIN = 1;
	private static final int TABLEAU_NUMBER_DESTINATION = 2;

	@Before
	public void before() {
		startGameController = new StartGameController();
		moveTableauToTableauController = new MoveTableauToTableauController(startGameController);
	}
	 
	@Test
	public void moveTest(){ //opposite color and lower
		startGameController.addCardToTableau(TABLEAU_NUMBER_ORIGIN, new Card(4,
				1));
		startGameController.addCardToTableau(TABLEAU_NUMBER_DESTINATION, new Card(5,
				3));
		moveTableauToTableauController.move(TABLEAU_NUMBER_ORIGIN, TABLEAU_NUMBER_DESTINATION);
		assertEquals(0, startGameController.getTableau(TABLEAU_NUMBER_ORIGIN).size());
		assertEquals(2, startGameController.getTableau(TABLEAU_NUMBER_DESTINATION).size());
	}
	
	@Test
	public void moveBadMovementTest(){
		startGameController.addCardToTableau(TABLEAU_NUMBER_ORIGIN, new Card(4,
				1));
		startGameController.addCardToTableau(TABLEAU_NUMBER_DESTINATION, new Card(5,
				1));
		moveTableauToTableauController.move(TABLEAU_NUMBER_ORIGIN, TABLEAU_NUMBER_DESTINATION);
		assertEquals(1, startGameController.getTableau(TABLEAU_NUMBER_ORIGIN).size());
		assertEquals(1, startGameController.getTableau(TABLEAU_NUMBER_DESTINATION).size());
		
	}

}
