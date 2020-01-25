import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class TTModel {

	private  ArrayList<cardAttributes> Deck = new ArrayList<>();
	ArrayList<Player> playerList = new ArrayList<>();
	private int numOfPlayers = 0;

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
		Player Six = new Player("Communal Pile", true, 6);
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
			for (int j = 1; j < numOfPlayers + 1; j++) {
				playerList.get(j).hand.add(Deck.get(deckIndex));
				deckIndex++;
				LDP = j;
			}
		}
		if (rmndr != 0) {
			for (int k = 0; k < rmndr; k++)
				if (LDP == 5) {
					LDP = 0;
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
		int winner = 0;
		int playerInc = 0;
		ArrayList<Player> activePlayers = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			boolean addToList;
			addToList = playerList.get(i).isPlayerActive();
			
			if (addToList == true) {
				activePlayers.add(playerList.get(i));
				

			}
		}

		if (a == 1) {
			for (int j = 0; j < activePlayers.size(); j++) {
				System.out.print(activePlayers.get(j).hand.get(1).getSize());

				// System.out.print(activePlayers.get(1).printHand());
			}
		}
	}
}
