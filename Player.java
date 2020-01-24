import java.util.ArrayList;

public class Player {
	private String name;
	private boolean isactive;
	ArrayList <Card> hand = new ArrayList<Card>();

	public Player(String n, boolean TorF) {
		this.name = n;
		this.isactive = TorF;
	}

	public String getPlayerName() {
		return name;
	}

	public boolean isPlayerActive() {
		return isactive;
	}
	
	public void getTopCard() {
		hand.get(0);
		
	}

	public void addToHand(Card card) {
		hand.add(card);
	}
		
	public String printHand() {
		String results = "";
		for(Card c : hand) {
			results +=  c.toString() + "\n";	
		}
		return results;
	}
    }
		

