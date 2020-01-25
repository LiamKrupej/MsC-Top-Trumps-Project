import java.util.ArrayList;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class cardValues {

    private static ArrayList<cardAttributes> Deck = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

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

        shuffleDeck(Deck);      // calls shuffleDeck class which shuffles list
        System.out.println();   // line break to improve formatting in test

        Player One = new Player("Player 1", true, 1);
        Player Two = new Player("Player 2", true, 2);
        Player Three = new Player("Player 3", true, 3);
        Player Four = new Player("Player 4", true, 4);
        Player Five = new Player("Player 5", true, 5);
        Player Six = new Player("Player 6", true, 6);

        int numActive = 0;
        numActive = numActive + checkNumActive(One);
        numActive = numActive +  checkNumActive(Two);
        numActive = numActive + checkNumActive(Three);
        numActive = numActive + checkNumActive(Four);
        numActive = numActive + checkNumActive(Five);
        numActive = numActive + checkNumActive(Six);

        System.out.println(numActive);
     }

    public static void shuffleDeck(List<cardAttributes> genDeck) {
        // shuffle deck using shuffle method from collections utility
        Collections.shuffle(Deck);
        // for loop to print cardAttributes for testing
        for (int l = 0; l < Deck.size(); l++) {
            // System.out.print(Deck.get(l)+" ");
            // System.out.println();
        }


    }

    public static int checkNumActive(Player p) {
        if (p.isPlayerActive() == true) {
            return 1;
        } else {
            return 0;
        }

    } 




}