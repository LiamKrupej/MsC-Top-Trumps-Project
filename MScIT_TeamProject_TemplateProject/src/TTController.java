  
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TTController {

	private TTModel model;
	private TTView	view;

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
		keyboardInput();
		
		
		
	}
	
	public void keyboardInput() {
		System.out.print( "Your top card is: " + "\n" + model.getTopCard() + "\n \n");
		System.out.println("Please select an attribute. 1 for Geographic, 2 for Duration, 3 for Population, 4 for Antiquity, 5 for Cool Factor.");
		Scanner s = new Scanner(System.in);
		int inputInt = s.nextInt();
		s.nextLine();
		model.compareCards(inputInt);
		
	}
	
}