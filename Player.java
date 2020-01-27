import java.util.ArrayList;

public class Player {
	private String name;
	private boolean isactive;
	private int PlayerNum = 0;
	ArrayList <cardAttributes> hand = new ArrayList<cardAttributes>();

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
	
	public String getName() {
		return this.hand.get(0).getName();
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
    }
		

