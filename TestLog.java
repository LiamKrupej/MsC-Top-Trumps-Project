package commandline;

import java.util.*; 
import java.io.*; 

public class TestLog {
	
	 FileWriter writer = new FileWriter("/Users/benscott/Downloads/MScIT_TeamProject_TemplateProject 2/bin/testlog.log");
	 BufferedWriter buffer = new BufferedWriter(writer);
		 
	public TestLog() throws IOException {

	}
	// prints initial deck to test log
	public void printInitialDeck(String deck) throws IOException {
		buffer.write("----------------------" + "\n");
		buffer.write("Initial Deck" + "\n");
		buffer.write(deck + "\n");
	}
	
	// prints deck after shuffle
	public void printShuffledDeck(String deck) throws IOException {
		buffer.write("---------------------------------------------" + "\n");
		buffer.write("Shuffled Deck" + "\n");
		buffer.write(deck + "\n");
	}
	public void playerHandsSurround() throws IOException {
		buffer.write("---------------------------------------------" + "\n");
		buffer.write("Player Hands");
	}
	// prints each players hand once cards dealt
	public void printPlayerHands(String playerHand, int p) throws IOException {
		buffer.write("\n" + "Player " + p + "'s hand:");		
		buffer.write(playerHand + "\n");

	}
	// prints communal pile each time cards are dealt 
	public void printCommunalPile(String communalPile) throws IOException {
		buffer.write(communalPile);
	}
	// prints top cards of each player
	public void printTopCards(String topCard) throws IOException {
		buffer.write(topCard);
	}
	
	public void closeBuffer() throws IOException {
		buffer.close();
	}
}
