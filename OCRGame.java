package overthrow.communist.regimes;

import java.util.Scanner;

class CommunistRegime {
    /* The communist regime class that defines placement and behaviour
       of each communist regime
     */
    int[] locationCells;
    int numOfHits;

    void setLocationCells(int[] loc) {
        locationCells = loc;
    }

    String checkYourself(int guess) {
        String result = "Miss";

        for (int locCell : locationCells) {
            if (locCell == guess) {
                result = "Hit";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length) {
            result = "Kill";
        }
        System.out.println(result);
        return result;
    }
}
public class OCRGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        CommunistRegime ocr = new CommunistRegime();

        // Set location cells of communist regime
        int initialLoc = (int) (Math.random() * 5);
        int[] locs = {initialLoc, initialLoc + 1, initialLoc + 2};
        ocr.setLocationCells(locs);

        boolean isAlive = true;

        while (isAlive) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int userGuess = scanner.nextInt();
            numOfGuesses++;
            String result = ocr.checkYourself(userGuess);

            if (result.equals("Kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses.");
            }
        }
    }
}

