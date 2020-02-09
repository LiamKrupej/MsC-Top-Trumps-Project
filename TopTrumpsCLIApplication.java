package commandline;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		TTModel model = new TTModel();
		TTView view = new TTView();
		TTController controller = new TTController(model, view);
		
		boolean writeGameLogsToFile = false; // Should we write game logs to file?
		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
		
		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		System.out.println("\n" + "Please choose whether you would like to View persistent game data = 0, Play a new game = 1, or quit = 2");
		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {

			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			Scanner userInput = new Scanner(System.in); 
			int userChoice = userInput.nextInt();
			userInput.nextLine();
			
			if (userChoice == 1) {
				controller.startGame();	
			} else if (userChoice == 0) {
				// database entry here to get data
			} else if (userChoice == 2) {
				userWantsToQuit=true; // use this when the user wants to exit the game
			}
		}


	}

}
