import javax.smartcardio.Card;

public class GameWinner {
	

private String winner;
private Player player;		// player of the game
public Model deck;			// from deck class

	public GameWinner(Player player, String winner, Model deck) {
		this.winner = winner;
		this.player = player;
		this.deck = deck;
	}

	
//The method Checks which player wins the game by comparing the number of cards he has to the number of cards in the deck

public boolean checkGameWinner() {

		int numPlayers = 4;	

for(int i=0; i<=numPlayers; i++){ // the loop to go through the number of players in the current game

		player.setActivity();
		
		if (player.getCardHand() == null) {		// gets the count of cards with a player
		player.getPlayerName();
		System.out.print(" \n player is out from the game");
		
		}else 
			
		if (player.getCardHand() == this.deck.size()) {	// discuss further in group what is expected here
			player.getPlayerName();
			System.out.print(" \n this player wins the game");
			}
		}	
	}
}

