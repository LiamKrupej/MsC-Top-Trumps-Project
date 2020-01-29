// AI player randomly selecting category from 1 to 5 //
import java.util.Random;
public class AISelect extends ExampleClass{ // referring to third class 
	private String choice = "";
	private Random r = new Random();
	
	public AISelect(int playerNum) { 
		
	}
	public String pickAnAttribute() {
		
		int number_of_categories = cardDeck.get(0);
		
		int choiceNumber = r.nextInt(number_of_categories); //nextInt used to generate random int value
		
		choice = cardDeck.get(0)[choiceNumber]; 
		
		return choice;
	}
}