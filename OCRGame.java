package overthrow.communist.regimes;

import java.util.ArrayList;
import java.util.Scanner;

class CommunistRegime {
    /* The communist regime class that defines placement and behaviour
       of each communist regime
     */
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }
    public String checkYourself(String userInput) {
        String result = "Miss";
        int idx = locationCells.indexOf(userInput);

        if (idx >= 0) {
            result = "Hit";
            locationCells.remove(idx);
            if (locationCells.isEmpty()) {
                result = "Kill";
            }
        }
        System.out.println(result);

        return result;
    }

}
public class OCRGame {

    // Declare instant variables
    OCRPlacer ocrp = new OCRPlacer();
    ArrayList<CommunistRegime> comRegimeList = new ArrayList<CommunistRegime>();
    int numGuesses;

    public void setUpGame() {
        // Initialize communist regime objects and set names
        int cellSize = 3;
        CommunistRegime crOne = new CommunistRegime();
        CommunistRegime crTwo = new CommunistRegime();
        CommunistRegime crThree = new CommunistRegime();

        crOne.setName("USSR");
        crTwo.setName("CCP");
        crThree.setName("PCV");

        comRegimeList.add(crOne);
        comRegimeList.add(crTwo);
        comRegimeList.add(crThree);

        for (CommunistRegime comRegime : comRegimeList) {
            ArrayList<String> crCells = ocrp.placeCR(cellSize);

            comRegime.setLocationCells(crCells);
        }
        System.out.println("In this game, you will guess the locations of totalitarian communist regimes");
        System.out.println("Take them all out (Well, assuming you are a capitalist.)");
        System.out.println("The communist regimes are USSR, CCP, PCV. Try to overthrow them with the fewest number of guesses.");
    }

    public void startPlaying() {
        while (!comRegimeList.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a cell coordinate (A0 to G6): ");
            String userGuess = scanner.next();
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    public void checkUserGuess(String userFeed) {
        numGuesses++;
        String result = "Miss";
        for (CommunistRegime comRegime : comRegimeList) {
            result = comRegime.checkYourself(userFeed);
            if (result.equals("Kill")) {
                System.out.println("Congratulations! You have overthrown " + comRegime.getName() + " Regime.");
                comRegimeList.remove(comRegime);
                break;
            }
            if (result.equals("Hit")) {
                break;
            }
            break;
        }
    }

    public void finishGame() {
        int optimalGuess = 18;
        System.out.println("Game over! It took you " + numGuesses + " guesses.");
        if (numGuesses >= optimalGuess) {
            System.out.println("It took you so long. You suck!");
        }
        else {
            System.out.println("You a champ for doing this in " + numGuesses + " guesses.");
        }
    }

    public static void main(String[] args) {
        OCRGame game = new OCRGame();
        game.setUpGame();
        game.startPlaying();
    }
}

