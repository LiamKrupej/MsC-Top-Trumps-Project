package Model;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TTController {

	private TTModel model; // model for inter round logic
	private TTView view; // view for printing to command line
	private int numActive; // number of active players
	private boolean gameActive = true; // game activity status
	public boolean waitCMD = false; // wait cmd for front end
	private boolean lastRoundDraw = false; // draw status from last round

	// overall game values for the database and front end to pull
	private int lastroundwinner = 1;
	private int totalofgames = 1;
	private int humanwins = 1;
	private int AIwins = 1;
	
	// last game values for the database and dront end to pull
	
	private int gamewinner = 0; //working


	public TTController(TTModel tModel, TTView tView) {
		model = tModel;
		view = tView;
	}
	
	

	public void startGame(boolean testLog) throws IOException {
		TestLog log = new TestLog(); // test log called for use if testlog is true

		model.readCards(); // reads cards from text file
		if (testLog == true) {
			log.printInitialDeck(model.printCompleteDeck()); // prints completed read deck to testlog
		}

		model.shuffleDeck(); // shuffles deck
		if (testLog == true) {
			log.printShuffledDeck(model.printShuffledDeck()); // prints shuffled deck to testlog
		}

		model.createPlayers(); // creates player objects necessary for game to run

		view.promptPlayerNum(); // command line output to prompt player number entry
		model.setNumPlayers(selectNumberOfPlayers()); // sets number of players by changing player activity to correct
														// number

		model.numOfActive(); // checks number of active players in playerlist array in model
		model.dealCards(); // deals cards amongst active players

		if (testLog == true) { // if test log is true prints each players hands after dealt
			log.playerHandsSurround(); // surrounds for formatting
			for (int i = 0; i < model.getActivePlayerNum(model.getActivePlayers()); i++) {
				log.printPlayerHands(model.getPlayerHand(model.getActivePlayers(), i), (i + 1));
			}
			log.playerHandsSurroundOut();
		}

		numActive = model.getActivePlayerNum(model.getActivePlayers()); // sets integer numactive to number of active
																		// players
		int roundNumber = 1; // round number started at a
		Random gameStarter = new Random(); // new random object
		int playerStarts = (gameStarter.nextInt(numActive) + 1); // selects random player to start, excluding 0
		int j = playerStarts; // j initially set to player chosen at random
		// do while loop only runs when game is active and more than one player is
		// active
		do {

			numActive = model.getActivePlayerNum(model.getActivePlayers());
			// prints top cards for each player each round
			if (testLog == true) {
				log.topCardsSurround(roundNumber);
				for (int i = 0; i < model.getActivePlayerNum(model.getActivePlayers()); i++) {
					log.printTopCards(model.getTopCard(model.getPlayerNum(model.getActivePlayers(), i)),
							model.getPlayerNum(model.getActivePlayers(), i));
				}
			}
			// prints round number
			view.printRound(roundNumber);

			// if j = 1 player turn
			if ((j == 1) && (model.isPlayerActive(j) == true)) {
				view.usersChoice(model.getPlayerName(j)); // prints player who is chosing
				int userChoice = keyboardInput(); // takes players keyboard input as choice
				model.compareCards(userChoice, model.getActivePlayers()); // compares all cards to find winner
				gameActive = checkWinConditions(); // checks win conditions
				roundNumber++; // increments round number
			} else if ((j != 1) && (model.isPlayerActive(j)) == true) { // if j is not 1, ai choice used
				view.aiTopCard(j, model.getTopCard(1)); // shows ai players top card
				view.usersChoice(model.getPlayerName(j)); // shows ai players choice of category
				numActive = model.getActivePlayerNum(model.getActivePlayers()); // gets number active
				model.compareCards(model.aiChoice(j, model.getActivePlayers()), model.getActivePlayers()); // compares
																											// all
																											// players
																											// top cards
																											// in round
				gameActive = checkWinConditions(); // checks win conditions
				roundNumber++; // increments round number by 1
			}
			// final check of win conditions
			gameActive = checkWinConditions();

			// shows communal pile if current or previous round uses it
			if (((model.getLastRoundWinner(model.getActivePlayers()) == 0) && (testLog == true))
					|| (lastRoundDraw = true)) {
				log.printCommunalPile(model.getCommunalPile(), roundNumber);
				if (lastRoundDraw = false) {
					lastRoundDraw = true;
				} else if ((lastRoundDraw = true) && (model.getLastRoundWinner(model.getActivePlayers()) != 0)) {
					lastRoundDraw = false;
				}
			}
			// prints to test log last round winner
			if ((model.getLastRoundWinner(model.getActivePlayers()) != j)
					&& (model.getLastRoundWinner(model.getActivePlayers()) != 0)) {
				j = model.getLastRoundWinner(model.getActivePlayers());

			}
			// wait cmd gives a break between each round, before user presses enter
			waitCMD = true;
			waitInput(waitCMD);

		} while (gameActive == true || numActive > 1);

		// prints winner from view
		view.printWinner(model.getWinner());
		
		System.out.print(model.getWinner());
		System.out.print(model.getNumOfDraws());
		System.out.print(model.getRoundsInGame());
		System.out.print("\n" + "Player one wins " + model.get1rounds() + " Player two wins " + model.get2rounds() + " PLayer 3 wins " + model.get3rounds() + " Player 4 wins " + model.get4rounds() + " Player 5 wins " + model.get5rounds());
		
		// printwinner of game once completed
		if (testLog == true) {
			log.printWinner(model.getWinner());
		}

		log.closeBuffer();
		return; // returns to command CLI application
	}

	// keyboard input for users choice of category
	public int keyboardInput() {
		view.userTopCard(model.getTopCard(1));
		view.promptCatSelect();
		Scanner s = new Scanner(System.in);
		int inputInt = s.nextInt();
		s.nextLine();
		return inputInt;

	}

	// runs through win/lose conditions and changes player status accordingly
	public boolean checkWinConditions() {
		model.loseCondition(model.getActivePlayers()); // checks if a player has lost
		gameActive = model.findWinner(model.getActivePlayers()); // finds if there is a winner
		numActive = model.getActivePlayerNum(model.getActivePlayers()); // checks numactive in case of eliminations
		return gameActive; // returns gameactive boolean, true if no winner, false if winner found
	}

	// waits for user to press enter before starting next round
	public void waitInput(boolean waitCMD) {
		if (waitCMD == true) {
			view.enterPrompt();
			Scanner prompt = new Scanner(System.in);
			prompt.nextLine();
		}
	}

	// returns waitcmd boolean for front end testing
	public boolean getWaitCMD() {
		return waitCMD;
	}

	// keyboard int entry for getting desired number of players
	public int selectNumberOfPlayers() {
		Scanner s = new Scanner(System.in);
		int numPlayers = s.nextInt();
		return numPlayers;
	}

}