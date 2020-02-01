  
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
			for (int j = 1; j <= numActive; j++) { 
				System.out.println(" J IS " + j + "*********");
				if ((j == 1) && (model.isPlayerActive(j) == true)) {				
					keyboardInput();
					gameActive =checkWinConditions();

				} else if (model.isPlayerActive(j) == true) {
					numActive = model.getActivePlayerNum(model.getActivePlayers());
					model.compareCards(model.aiChoice(j, model.getActivePlayers()), model.getActivePlayers());
					gameActive = checkWinConditions();
				} else {
					gameActive = checkWinConditions();
				}
			} 
		} while(gameActive == true);

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