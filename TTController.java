package commandline;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TTController {

	private TTModel model;
	private TTView	view;
	private int numActive;
	private boolean gameActive = true;
	public boolean waitCMD = false;
	private boolean lastRoundDraw = false;

	public TTController(TTModel tModel, TTView tView) {
		model = tModel;
		view = tView;
	}

	public void startGame(boolean testLog) throws IOException{
		TestLog log = new TestLog();
		model.readCards();
		
			if (testLog == true) {
				log.printInitialDeck(model.printCompleteDeck());
			}
			
		model.shuffleDeck();
		
			if (testLog == true) {
				log.printShuffledDeck(model.printShuffledDeck());
			}
			
		model.createPlayers();
		
		view.promptPlayerNum();
		model.setNumPlayers(selectNumberOfPlayers());
		
		model.numOfActive();
		model.dealCards();
		
			if (testLog == true) {
				log.playerHandsSurround();
				for (int i = 0; i < model.getActivePlayerNum(model.getActivePlayers()); i++) {
					log.printPlayerHands(model.getPlayerHand(model.getActivePlayers(), i), (i+1));
				}
				log.playerHandsSurroundOut();
			}
		
		numActive = model.getActivePlayerNum(model.getActivePlayers());
		int roundNumber = 1;
		Random gameStarter = new Random();
		int playerStarts = (gameStarter.nextInt(numActive) + 1);
		int j = playerStarts;	
		
		do {

			numActive = model.getActivePlayerNum(model.getActivePlayers()); 
			
			if (testLog == true) {
				log.topCardsSurround(roundNumber);
				for (int i = 0; i < model.getActivePlayerNum(model.getActivePlayers()); i++) {
					log.printTopCards(model.getTopCard(model.getPlayerNum(model.getActivePlayers(), i)), model.getPlayerNum(model.getActivePlayers(), i));
				}
			}
		
				view.printRound(roundNumber);

				
				if ((j == 1) && (model.isPlayerActive(j) == true)) {			
					view.usersChoice(model.getPlayerName(j));
					int userChoice = keyboardInput();	
					model.compareCards(userChoice, model.getActivePlayers());
					gameActive =checkWinConditions();
					roundNumber++;		
				} else if ((j != 1) && (model.isPlayerActive(j)) == true) {
					view.aiTopCard(j, model.getTopCard(1));
					view.usersChoice(model.getPlayerName(j));
					numActive = model.getActivePlayerNum(model.getActivePlayers());
					model.compareCards(model.aiChoice(j, model.getActivePlayers()), model.getActivePlayers());
					gameActive = checkWinConditions();
					roundNumber++;
				}
				
				gameActive = checkWinConditions();

				
				if (((model.getLastRoundWinner(model.getActivePlayers()) == 0) && (testLog == true)) || (lastRoundDraw = true)) {
					log.printCommunalPile(model.getCommunalPile(), roundNumber);
					if (lastRoundDraw = false) {
						lastRoundDraw = true;
					} else if ((lastRoundDraw = true) && (model.getLastRoundWinner(model.getActivePlayers()) != 0)) {
						lastRoundDraw = false;
					}
				}
				
				if ((model.getLastRoundWinner(model.getActivePlayers()) != j) && (model.getLastRoundWinner(model.getActivePlayers()) != 0)) {
					j = model.getLastRoundWinner(model.getActivePlayers());

				}
				
				waitCMD = true;
				waitInput(waitCMD);
				
		} while(gameActive == true || numActive > 1);		


		
		view.printWinner(model.getWinner());
		
		if (testLog == true) {
			log.printWinner(model.getWinner());
		}
		
		log.closeBuffer();
		return;
	}
	
	public int keyboardInput() {
		view.userTopCard(model.getTopCard(1));
		view.promptCatSelect();
		Scanner s = new Scanner(System.in);
		int inputInt = s.nextInt();
		s.nextLine();
		return inputInt;
		
	}

	public boolean checkWinConditions() {
		model.loseCondition(model.getActivePlayers());
		gameActive = model.findWinner(model.getActivePlayers());
		numActive = model.getActivePlayerNum(model.getActivePlayers());
		return gameActive;
	}
	
	public void waitInput(boolean waitCMD){
		if (waitCMD == true) {
		   view.enterPrompt();
		   Scanner prompt = new Scanner(System.in);
		   prompt.nextLine();
		}
	}
	
	public boolean getWaitCMD() {
		return waitCMD;
	}
	
	public int selectNumberOfPlayers() {
		Scanner s = new Scanner(System.in);
		int numPlayers = s.nextInt();
		return numPlayers;
	}
	
}	
