import java.util.Random;
import java.util.*;

public class CardShuffle {

	public static void main(String args[]) {

		ArrayList<Integer> shuffledDeck = new ArrayList<Integer> (40);

		for (int k = 0; k < 40; k++) {
			shuffledDeck.add(k);
		}

		Collections.shuffle(shuffledDeck);

		for (int l = 0; l < 40; l++) {
			System.out.print(shuffledDeck.get(l)+" ");
		}
		System.out.println();

	}

}
