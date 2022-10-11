package overthrow.communist.regimes;

import java.util.ArrayList;
import java.util.Scanner;

class CommunistRegime {
    /* The communist regime class that defines placement and behaviour
       of each communist regime
     */
    private ArrayList<String> locationCells;
    private int numOfHits;
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
        }
        if (locationCells.isEmpty()) {
            result = "Kill";
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

        crOne.setName();
        crTwo.setName();
        crThree.setName();

        comRegimeList.add(crOne);
        comRegimeList.add(crTwo);
        comRegimeList.add(crThree);

        for (CommunistRegime comRegime : comRegimeList) {
            ArrayList<String> crCells = ocrp.placeCR(cellSize);

            comRegime.setLocationCells(crCells);
        }
        System.out.println("In this game, you will guess the locations of totalitarian communist regimes");
        System.out.println("Take them all out (Well, assuming you are a capitalist.)");
        System.out.println("The communist regimes are USSR, CCP, PCV. Try to overthrow them with the fewest number of guesses.")
    }

    public void startPlaying() {
        boolean isAlive = true;
        while (isAlive) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a cell coordinate (A1 to G7): ");
            String userGuess = scanner.next();

            for (CommunistRegime comRegime : comRegimeList) {
                String result = comRegime.checkYourself(userGuess);
                }
            if (comRegimeList.isEmpty()) {
                isAlive = false;
            }
        }
    }
    public String checkUserGuess(String userGuess) {
        numGuesses++;
        String result = "Miss";
        for (CommunistRegime comRegime : comRegimeList) {
            result = comRegime.checkYourself(userGuess);
            if (result.equals("Kill")) {
                System.out.println("Congratulations! You have overthrown " + comRegime.getName() + " Regime.");
                comRegimeList.remove(comRegime);
            }
        }
        System.out.println(result);
        if (comRegimeList.isEmpty()) {
            isAlive;
        }
        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        int numOfGuesses = 0;
        CommunistRegime ocr = new CommunistRegime();

        // Set location cells of communist regime
        int initialLoc = (int) (Math.random() * 5);
        ArrayList<String> locs = new ArrayList<String>();
        locs.add(Integer.toString(initialLoc));
        locs.add(Integer.toString(initialLoc + 1));
        locs.add(Integer.toString(initialLoc + 2));

        ocr.setLocationCells(locs);

        boolean isAlive = true;

        while (isAlive) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            String userGuess = scanner.next();
            numOfGuesses++;
            String result = ocr.checkYourself(userGuess);

            if (result.equals("Kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses.");
            }
        }
    }
}

