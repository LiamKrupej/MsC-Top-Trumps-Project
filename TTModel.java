import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class TTModel {

	private ArrayList<cardAttributes> Deck = new ArrayList<>();
	private ArrayList<Player> playerList = new ArrayList<>();
	private int numOfPlayers = 0;
	int winner = 0;
	ArrayList<Player> activePlayers = new ArrayList<Player>();
	ArrayList<Player> currentHighest = new ArrayList<Player>();
	int gamewinner = 0;
	boolean gameactive = true;

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

	public void shuffleDeck() {
		// shuffle deck using shuffle method from collections utility
		Collections.shuffle(Deck);
		// for loop to print cardAttributes for testing
		// for (int l = 0; l < Deck.size(); l++) {
		// // System.out.print(Deck.get(l)+" ");
		// // System.out.println();
		// }
	}

	public void numOfActive() {
		for (int i = 5; i >= 1; i--) {
			if (playerList.get(i).isPlayerActive() == true) {
				numOfPlayers = numOfPlayers + 1;
			}
		}

	}

	public void dealCards() {
		int DR = Deck.size() / (numOfPlayers);
		int rmndr = Deck.size() % (numOfPlayers);
		int deckIndex = 0;
		int LDP = 0;

		for (int i = 0; i < DR; i++) {
			for (int j = 1; j <= (numOfPlayers); j++) {
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

	public void compareCards(int a) {
		int playerInc = 0;
		for (int i = 1; i <= 5; i++) {
			boolean addToList;
			addToList = playerList.get(i).isPlayerActive();
			if (addToList == true) {
				activePlayers.add(playerList.get(i));
			}
		}

		if (a == 1) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has the " + activePlayers.get(j).getName() + " card with size %01d", activePlayers.get(j).getPlayerName(),
						activePlayers.get(j).getGeo()));

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
			} else {
				System.out.println(String.format("%s has the highest card for this round, with a value of %01d",
						currentHighest.get(0).getPlayerName(), currentHighest.get(0).getGeo()));
			}

		}
		if (a == 2) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has the " + activePlayers.get(j).getName() + " card with duration %01d",
						activePlayers.get(j).getPlayerName(), activePlayers.get(j).getDur()));

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
			} else {
				System.out.println(String.format("%s has the highest card for this round, with a value of %01d",
						currentHighest.get(0).getPlayerName(), currentHighest.get(0).getDur()));
			}

		}

		if (a == 3) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has the " + activePlayers.get(j).getName() + " card with population %01d",
						activePlayers.get(j).getPlayerName(), activePlayers.get(j).getPop()));

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
			} else {
				System.out.println(String.format("%s has the highest card for this round, with a value of %01d",
						currentHighest.get(0).getPlayerName(), currentHighest.get(0).getPop()));
			}

		}

		if (a == 4) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has the " + activePlayers.get(j).getName() + " card with antiquity %01d",
						activePlayers.get(j).getPlayerName(), activePlayers.get(j).getAnt()));

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
			} else {
				System.out.println(String.format("%s has the highest card for this round, with a value of %01d",
						currentHighest.get(0).getPlayerName(), currentHighest.get(0).getAnt()));
			}

		}

		if (a == 5) {
			for (int j = 0; j < activePlayers.size(); j++) {
				// roundResults.add(activePlayers.get(j).getGeo());
				System.out.println(String.format("%s has the " + activePlayers.get(j).getName() + " card with cool factor %01d",
						activePlayers.get(j).getPlayerName(), activePlayers.get(j).getCool()));

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
			} else {
				System.out.println(String.format("%s has the highest card for this round, with a value of %01d",
						currentHighest.get(0).getPlayerName(), currentHighest.get(0).getCool()));
			}

		}
	}

	public void loseCondition() {
		for (int i = 0; i <= activePlayers.size(); i++) {
			if (activePlayers.get(i).hand.get(0) == null) {
				activePlayers.get(i).setPlayerActivity(false);
			}
		}

	}
	
	public void findWinner () {
		for (int i = 0; i <= activePlayers.size(); i ++) {
			if (activePlayers.get(i).hand.size() == 40) {
				gamewinner = activePlayers.get(i).getPlayerNum();					
			}
		}
		
		if (gamewinner != 0) {
			gameactive = false;
			
		}
		
	}
	
}
