  
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TTController {

	private TTModel model;
	private TTView	view;
	private int numActive;
	private boolean gameActive = true;

	public TTController(TTModel tModel, TTView tView) {
		model = tModel;
		view = tView;
	}

	public void startGame() throws FileNotFoundException{
		model.readCards();
		model.shuffleDeck();
		model.createPlayers();
		model.numOfActive();
		model.dealCards();

		do {
			numActive = model.getActivePlayerNum(model.getActivePlayers()); 
			int highestRemainingPlayer = model.getHighestActivePlayer();
			for (int j = 1; j <= highestRemainingPlayer ; j++) { 							// incorrect alogrithm. currently not running all players.
				if ((j == 1) && (model.isPlayerActive(j) == true)) {		// j needs to run through active player numbers			
					keyboardInput();										// not increment through index of activeplayers
					gameActive =checkWinConditions();
					highestRemainingPlayer = model.getHighestActivePlayer();
				} else if ((j != 1) && (model.isPlayerActive(j)) == true) {
					numActive = model.getActivePlayerNum(model.getActivePlayers());
					model.compareCards(model.aiChoice(j, model.getActivePlayers()), model.getActivePlayers());
					gameActive = checkWinConditions();
					highestRemainingPlayer = model.getHighestActivePlayer();
				} else {
					gameActive = checkWinConditions();
					highestRemainingPlayer = model.getHighestActivePlayer();
				}
			} 
		} while(gameActive == true || numActive > 1);

		System.out.println("Player " + model.getWinner() + " has won the game");
	}
	
	public void keyboardInput() {
		System.out.print( "Your top card is: " + "\n" + model.getTopCard() + "\n \n");
		System.out.println("Please select an attribute. 1 for Geographic, 2 for Duration, 3 for Population, 4 for Antiquity, 5 for Cool Factor.");
		Scanner s = new Scanner(System.in);
		int inputInt = s.nextInt();
		s.nextLine();
		model.compareCards(inputInt, model.getActivePlayers());
		
	}

	public boolean checkWinConditions() {
		model.loseCondition(model.getActivePlayers());
		gameActive = model.findWinner(model.getActivePlayers());
		numActive = model.getActivePlayerNum(model.getActivePlayers());
		return gameActive;
	}
	
}