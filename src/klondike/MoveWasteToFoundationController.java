package klondike;

public class MoveWasteToFoundationController {
	private StartGameController startGameController;
	
	public MoveWasteToFoundationController(StartGameController starGameController){
		this.startGameController = starGameController;
	}
		 
	public void move(int foundationPositionNumber) {
		Card card = startGameController.getFirstCardWaste();
		
	}

}
