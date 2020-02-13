package Model;

import commandline.TestLog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TTController {

    private TTModel model;
    private TTView	view;
    private int numActive;
    private boolean gameActive = true;
    private boolean gameCompleted = false;

    public TTController(TTModel tModel, TTView tView) {
        model = tModel;
        view = tView;
    }

    public void startGame(boolean testLog) throws IOException{
        TestLog log = new TestLog();
        model.readCards();

        if (testLog == true) {
            log.printInitialDeck(model.printCompleteDeck());
        }

        model.shuffleDeck();

        if (testLog == true) {
            log.printShuffledDeck(model.printShuffledDeck());
        }

        model.createPlayers();
        model.numOfActive();
        model.dealCards();

        if (testLog == true) {
            log.playerHandsSurround();
            for (int i = 0; i < model.getActivePlayerNum(model.getActivePlayers()); i++) {
                log.printPlayerHands(model.getPlayerHand(model.getActivePlayers(), i), (i+1));
            }
            log.playerHandsSurroundOut();
        }

        numActive = model.getActivePlayerNum(model.getActivePlayers());
        int roundNumber = 1;
        Random gameStarter = new Random();
        int playerStarts = (gameStarter.nextInt(numActive) + 1);
        int j = playerStarts;
        do {

            numActive = model.getActivePlayerNum(model.getActivePlayers());
            int highestRemainingPlayer = model.getHighestActivePlayer();

            if (testLog == true) {
                log.topCardsSurround(roundNumber);
                for (int i = 0; i < model.getActivePlayerNum(model.getActivePlayers()); i++) {
                    log.printTopCards(model.getTopCard(model.getPlayerNum(model.getActivePlayers(), i)), model.getPlayerNum(model.getActivePlayers(), i));
                }
            }

            System.out.println("ROUND " + roundNumber);

            if ((j == 1) && (model.isPlayerActive(j) == true)) {		// j needs to run through active player numbers
                System.out.println(model.getPlayerName(j) + "'s choice");
                keyboardInput();										// not increment through index of activeplayers
                gameActive =checkWinConditions();
                highestRemainingPlayer = model.getHighestActivePlayer();
                roundNumber++;
            } else if ((j != 1) && (model.isPlayerActive(j)) == true) {
                System.out.println(model.getPlayerName((j)) + "'s choice");
                numActive = model.getActivePlayerNum(model.getActivePlayers());
                model.compareCards(model.aiChoice(j, model.getActivePlayers()), model.getActivePlayers());
                gameActive = checkWinConditions();
                highestRemainingPlayer = model.getHighestActivePlayer();
                roundNumber++;
            } else {
                gameActive = checkWinConditions();
                highestRemainingPlayer = model.getHighestActivePlayer();
            }

            if ((model.getLastRoundWinner(model.getActivePlayers()) == 0) && (testLog == true)) {
                log.printCommunalPile(model.getCommunalPile(), roundNumber);
            }

            if ((model.getLastRoundWinner(model.getActivePlayers()) != j) && (model.getLastRoundWinner(model.getActivePlayers()) != 0)) {
                j = model.getLastRoundWinner(model.getActivePlayers());

            }


        } while(gameActive == true || numActive > 1);




        System.out.println("Player " + model.getWinner() + " has won the game");
        log.closeBuffer();
        return;
    }

    public void keyboardInput() {
        System.out.print( "Your top card is: " + "\n" + model.getTopCard(1) + "\n \n");
        System.out.println("Please select an attribute. 1 for Geographic, 2 for Duration, 3 for Population, 4 for Antiquity, 5 for Cool Factor.");
        Scanner s = new Scanner(System.in);
        int inputInt = s.nextInt();
        s.nextLine();
        model.compareCards(inputInt, model.getActivePlayers());

    }

    public boolean checkWinConditions() {
        model.loseCondition(model.getActivePlayers());
        gameActive = model.findWinner(model.getActivePlayers());
        numActive = model.getActivePlayerNum(model.getActivePlayers());
        return gameActive;
    }
}