package commandline;
import java.util.ArrayList;

/*
	The player object holds all of the information relating to each game player
	This includes the player name, their game active state, a player number and an array list containing their hand
	it also includes a number of getter and setters for these values
*/
public class Player {
	private String name;
	private boolean isactive;
	private int PlayerNum = 0;
	ArrayList <cardAttributes> hand = new ArrayList<cardAttributes>();

	// each player object is constructed with a name, an active state and a player number
	public Player(String n, boolean TorF, int PN) {
		this.PlayerNum = PN; 
		this.name = n;
		this.isactive = TorF;
	}

	public String getPlayerName() {
		return name;
	}
	
	public int getPlayerNum() {
		return PlayerNum;
	}

	public boolean isPlayerActive() {
		return isactive;
	}
	
	public void setPlayerActivity(boolean OorF) {
		isactive = OorF;
		
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

	public int getGeo() {
		return this.hand.get(0).getSize();
	}

	public int getDur() {
		return this.hand.get(0).getDuration();
	}

	public int getPop() {
		return this.hand.get(0).getPopulation();
	}

	public int getAnt() {
		return this.hand.get(0).getAntiquity();
	}

	public int getCool() {
		return this.hand.get(0).getCoolFactor();
	}

	public String getCardName() {
		return String.format(this.hand.get(0).getNameFirst() + " " + this.hand.get(0).getNameLast());
	}

	public cardAttributes getTopCard() {
		return this.hand.get(0);
	}

	public void removeTopCard() {
		this.hand.remove(0);
	}




}
