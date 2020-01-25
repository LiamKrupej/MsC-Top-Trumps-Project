import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class TTModel {
	
	private static ArrayList<cardAttributes> Deck = new ArrayList<>();
	ArrayList<Player> playerList = new ArrayList<>();

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
	for(int i = 6; i > (a + 1); i-- ) {
		playerList.get(i).setPlayerActivity(false);
	}
	
	}
		


    public static void shuffleDeck() {
        // shuffle deck using shuffle method from collections utility
        Collections.shuffle(Deck);
        // for loop to print cardAttributes for testing
        // for (int l = 0; l < Deck.size(); l++) {
        //     // System.out.print(Deck.get(l)+" ");
        //     // System.out.println();
        // }
    }

    public static int checkNumActive(Player p) {
        if (p.isPlayerActive() == true) {
            return 1;
        } else {
            return 0;
        }

    } 

}
