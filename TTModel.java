import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.lang.Math;

public class TTModel {

	private  ArrayList<cardAttributes> Deck = new ArrayList<>();
	private ArrayList<Player> playerList = new ArrayList<>();
	private int winner = 0;
	private int numOfPlayers = 0;
	private int gameWinner = 0;
	private boolean gameActive = true;

	public TTModel() {

		this.Deck = Deck;
		this.playerList = playerList;

	}

	public void readCards() throws FileNotFoundException {

		File text = new File("Empires.txt");
		Scanner civilizations = new Scanner(text);

		while (civilizations.hasNextLine()) {

			String NameFirst = civilizations.next();
			String NameLast = civilizations.next();
			int Size = civilizations.nextInt();
			int Duration = civilizations.nextInt();
			int Population = civilizations.nextInt();
			int Antiquity = civilizations.nextInt();
			int CoolFactor = civilizations.nextInt();

			Deck.add(new cardAttributes(NameFirst, NameLast, Size, Duration, Population, Antiquity, CoolFactor));
		}
	}

	public void createPlayers() {
		Player One = new Player("Player 1", true, 1);
		Player Two = new Player("Player 2", true, 2);
		Player Three = new Player("Player 3", true, 3);
		Player Four = new Player("Player 4", true, 4);
		Player Five = new Player("Player 5", true, 5);
		Player Six = new Player("Communal Pile", false, 0);
		playerList.add(Six);
		playerList.add(One);
		playerList.add(Two);
		playerList.add(Three);
		playerList.add(Four);
		playerList.add(Five);

	}

	public void choosePlayers(int a) {
		for (int i = 5; i > (a + 1); i--) {
			playerList.get(i).setPlayerActivity(false);
		}

	}

	public  void shuffleDeck() {
		// shuffle deck using shuffle method from collections utility
		Collections.shuffle(Deck);
		// for loop to print cardAttributes for testing
		// for (int l = 0; l < Deck.size(); l++) {
		// // System.out.print(Deck.get(l)+" ");
		// // System.out.println();
		// }
	}

	public void numOfActive() {
		for (int i = 5; i > 1; i--) {
			if (playerList.get(i).isPlayerActive() == true) {
				numOfPlayers = numOfPlayers + 1;
			}
		}

	}

	public void dealCards() {
		int DR = Deck.size() / (numOfPlayers + 1);
		int rmndr = Deck.size() % (numOfPlayers + 1);
		int deckIndex = 0;
		int LDP = 0;

		for (int i = 0; i < DR; i++) {
			for (int j = 1; j <= (numOfPlayers + 1); j++) {
				playerList.get(j).hand.add(Deck.get(deckIndex));
				deckIndex++;
				LDP = j;
			}
		}
		if (rmndr != 0) {
			for (int k = 0; k < rmndr; k++)
				if (LDP == 5) {
					LDP = 1;
				}
			playerList.get(LDP + 1).hand.add(Deck.get(deckIndex));
		}

	}

	public String getTopCard() {
		String s = null;
		s = playerList.get(1).hand.get(0).toString();
		return s;
	}

	public ArrayList<Player> getActivePlayers() {

		ArrayList<Player> activePlayers = new ArrayList<Player>();

		for (int i = 1; i <= 5; i++) {
			boolean addToList;
			addToList = playerList.get(i).isPlayerActive();
			if (addToList == true) {
				activePlayers.add(playerList.get(i));
			}
		}
		return activePlayers;
	}

	public int getActivePlayerNum(ArrayList<Player> aP) {
		return aP.size();
	}

	public int compareCards(int a, ArrayList<Player> aP) {
		int winner = 0;
		int draw = 0;
		ArrayList<Player> activePlayers = aP;
		ArrayList<Player> currentHighest = new ArrayList<Player>();

		if (a == 1) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has %s with size %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getGeo()));
				if (j == 0) {
					currentHighest.add(0, activePlayers.get(j));
				} else if (j == 1) {
					currentHighest.add(1, activePlayers.get(j));
				}


				if (activePlayers.get(j).getGeo() >= currentHighest.get(0).getGeo()) {
					currentHighest.add(1, currentHighest.get(0));
					currentHighest.add(0, activePlayers.get(j));
				}

			}

			if (currentHighest.get(0).getGeo() == currentHighest.get(1).getGeo()) {
				System.out.println("There is a draw and the cards will be added to the communal pile");
				draw = 1;
			} else {
				System.out.println(String.format("%s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getGeo()));	
				draw = 0;			
			}

			if (draw == 1) {
				currentHighest.add(0, playerList.get(0));			
			} else {
				winner = currentHighest.get(0).getPlayerNum();
			}

		}



		if (a == 2) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has %s with duration %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getDur()));

				if (j == 0) {
					currentHighest.add(0, activePlayers.get(j));
				} else if (j == 1) {
					currentHighest.add(1, activePlayers.get(j));
				}


				if (activePlayers.get(j).getDur() >= currentHighest.get(0).getDur()) {
					currentHighest.add(1, currentHighest.get(0));
					currentHighest.add(0, activePlayers.get(j));
				}

			}

			if (currentHighest.get(0).getDur() == currentHighest.get(1).getDur()) {
				System.out.println("There is a draw and the cards will be added to the communal pile");
				draw = 1;
			} else {
				System.out.println(String.format("%s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getDur()));	
				draw = 0;			
			}

			if (draw == 1) {
				currentHighest.add(0, playerList.get(0));			
			} else {
				winner = currentHighest.get(0).getPlayerNum();
			}

		}

		if (a == 3) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has %s with population %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getPop()));
				if (j == 0) {
					currentHighest.add(0, activePlayers.get(j));
				} else if (j == 1) {
					currentHighest.add(1, activePlayers.get(j));
				}


				if (activePlayers.get(j).getPop() >= currentHighest.get(0).getPop()) {
					currentHighest.add(1, currentHighest.get(0));
					currentHighest.add(0, activePlayers.get(j));
				}

			}

			if (currentHighest.get(0).getPop() == currentHighest.get(1).getPop()) {
				System.out.println("There is a draw and the cards will be added to the communal pile");
				draw = 1;
			} else {
				System.out.println(String.format("%s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getPop()));	
				draw = 0;			
			}

			if (draw == 1) {
				currentHighest.add(0, playerList.get(0));			
			} else {
				winner = currentHighest.get(0).getPlayerNum();
			}


		}

		if (a == 4) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has %s with antiquity %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getAnt()));
				if (j == 0) {
					currentHighest.add(0, activePlayers.get(j));
				} else if (j == 1) {
					currentHighest.add(1, activePlayers.get(j));
				}


				if (activePlayers.get(j).getAnt() >= currentHighest.get(0).getAnt()) {
					currentHighest.add(1, currentHighest.get(0));
					currentHighest.add(0, activePlayers.get(j));
				}

			}

			if (currentHighest.get(0).getAnt() == currentHighest.get(1).getAnt()) {
				System.out.println("There is a draw and the cards will be added to the communal pile");
				draw = 1;
			} else {
				System.out.println(String.format("%s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getAnt()));	
				draw = 0;			
			}

			if (draw == 1) {
				currentHighest.add(0, playerList.get(0));			
			} else {
				winner = currentHighest.get(0).getPlayerNum();
			}


		}

		if (a == 5) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has %s with cool factor %01d", activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCardName(), activePlayers.get(j).getCool()));
				if (j == 0) {
					currentHighest.add(0, activePlayers.get(j));
				} else if (j == 1) {
					currentHighest.add(1, activePlayers.get(j));
				}


				if (activePlayers.get(j).getCool() >= currentHighest.get(0).getCool()) {
					currentHighest.add(1, currentHighest.get(0));
					currentHighest.add(0, activePlayers.get(j));
				}

			}

			if (currentHighest.get(0).getCool() == currentHighest.get(1).getCool()) {
				System.out.println("There is a draw and the cards will be added to the communal pile");
				draw = 1;
			} else {
				System.out.println(String.format("\n %s has the highest card for this round, with a value of %01d", currentHighest.get(0).getPlayerName(), currentHighest.get(0).getCool()));	
				draw = 0;			
			}

			if (draw == 1) {
				currentHighest.add(0, playerList.get(0));			
			} else {
				winner = currentHighest.get(0).getPlayerNum();
			}

		}
		System.out.println(playerList.get(0).printHand() + " *start* ");
		addWinnerCards(winner, draw, activePlayers);
		return winner;
	}

	/* 
		add winner cards takes winner, draw and the active players list as its parameters
		using these it distributes the cards either to the winning players hand
		or in the case of a draw to the communal pile for redistribution in the next
		player won round
	*/

	public void addWinnerCards(int w, int d, ArrayList<Player> activePlayers) {

		int numberActive = activePlayers.size();		// size of current player list initialised for ease of use

		if (d == 1) {																// first if loop runs only if draw
			for (int i = 0; i < numberActive; i++) {								// runs for ever currently active player
				numberActive = activePlayers.size();							
				playerList.get(0).addToHand(activePlayers.get(i).getTopCard());		// removes first card from active player
				loseCondition(activePlayers);		
			}																		// and adds to communal pile player object
		} else {
			for (int j = 0; j < numberActive; j++) {								// if not a draw
				numberActive = activePlayers.size();
				playerList.get(w).addToHand(activePlayers.get(j).getTopCard());		// every player, including winners cards are added at end of list				
				activePlayers.get(j).removeTopCard();								// and the top card is removed from all players
				loseCondition(activePlayers);
			}

			// the next section runs for every player won round to add all cards which are in communal pile

			int numComPile = playerList.get(0).hand.size();		// gets size of current communal pile hand
			for (int k = 0; k < numComPile; k++) {				// runs through every index of communal pile hand
				if (activePlayers.get(0).hand.isEmpty() == false) {
					playerList.get(w).addToHand(activePlayers.get(0).getTopCard());
					activePlayers.get(0).removeTopCard();		// and adds to players hand list
					loseCondition(activePlayers);
				}
			}
		}

		System.out.println("*communal pile cards*" + playerList.get(0).printHand() + " *end communal pile* ");
		System.out.println("*start winner hand*" + playerList.get(w).printHand() + " *end winner list* ");
	}



	public int aiChoice(int p, ArrayList<Player> activePlayers) {

		int cardGeo = playerList.get(p).getGeo();				// intialised variables with the card attributes
		int cardDur = playerList.get(p).getDur();
		int cardPop = playerList.get(p).getPop();
		int cardAnt = playerList.get(p).getAnt();
		int cardCool = playerList.get(p).getAnt();

		int biggest = Math.max(cardGeo,Math.max(cardDur,Math.max(cardPop,Math.max(cardAnt,cardCool))));	// returns highest value card

		if (cardGeo == biggest) {
			System.out.println("Player " + p + " has chosen Geographic size");
			return 1;
		} else if (cardDur == biggest) {
			System.out.println("Player " + p + " has chosen Duration");
			return 2;
		} else if (cardPop == biggest) {
			System.out.println("Player " + p + " has chosen Population");
			return 3;
		} else if (cardAnt == biggest) {
			System.out.println("Player " + p + " has chosen Antiquity");
			return 4;
		} else {
			System.out.println("Player " + p + " has chosen Cool Factor");
			return 5;
		}
	
	}

	public boolean isGameActive() {
		return gameActive;
	}

	public void loseCondition(ArrayList<Player> activePlayers) {
		for (int i = 0; i < activePlayers.size(); i++) {
			if (activePlayers.get(i).hand.isEmpty() == true) {
				activePlayers.get(i).setPlayerActivity(false);
			}
		}

	}

	public void findWinner (ArrayList<Player> activePlayers) {
		for (int i = 0; i < activePlayers.size(); i ++) {
			if (activePlayers.get(i).hand.size() == 40) {
				gameWinner = activePlayers.get(i).getPlayerNum();					
			}
		}

		if (gameWinner != 0) {
			gameActive = false;
		}
	}

	public int getWinner() {
		return gameWinner;
	}


}