import java.util.ArrayList;

public class Player {
	private String name;
	private boolean isactive;
	private int playerNum;
	ArrayList <cardAttributes> hand = new ArrayList<cardAttributes>();

	public Player(String n, boolean TorF, int playerNum) {
		this.name = n;
		this.isactive = TorF;
		this.playerNum = playerNum;
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

	public void addToHand(cardAttributes card) {
		hand.add(card);
	}
		
	public String printHand() {
		String results = "";
		for(cardAttributes c : hand) {
			results +=  c.toString() + "\n";	
		}
		return results;
	}
    }
		