import java.util.ArrayList;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class cardValues2 {

    private static List<cardAttributes> Deck = new ArrayList<>(40);

    public static void main(String[] args) throws FileNotFoundException {

        File text = new File("/Users/benscott/Documents/ITMastersProject/Empires.txt");
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

        Random randomGenerator;
        randomGenerator = new Random();
        int index = randomGenerator.nextInt(Deck.size());
        System.out.println(Deck.get(index));

    }
}




