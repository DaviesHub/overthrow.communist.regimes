package overthrow.communist.regimes;

class CommunistRegime {
    /* The communist regime class that defines placement and behaviour
       of each communist regime
     */
    int[] locationCells;
    int numOfHits;

    void setLocationCells(int[] loc) {
        locationCells = loc;
    }

    String checkYourself(String userGuess) {
        int guess = Integer.parseInt(userGuess);
        String result = "Miss";

        for (int locCell : locationCells) {
            if (locCell == guess) {
                result = "Hit";
                numOfHits++;
                break;
            }
            if (numOfHits == locationCells.length) {
                result = "Kill";
            }
            System.out.println(result);
        }
        return result;
    }
}
public class OCRGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        CommunistRegime ocr = new CommunistRegime();
    }

}

