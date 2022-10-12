package overthrow.communist.regimes;

import java.util.*;
public class OCRPlacer {
    private static final String alphabet = "ABCDEFG";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int crCount = 0;

    public ArrayList<String> placeCR(int crSize) {
        ArrayList<String> alphaCells = new ArrayList<String>(); // holds ‘f6’ type coords
        String temp = null; // temporary String for concat
        int [] coords = new int[crSize]; // current candidate coords
        int attempts = 0; // current attempts counter
        boolean success = false; // flag = found a good location ?
        int location = 0; // current starting location
        crCount++; // nth dot com to place
        int incr = 1; // set horizontal increment
        if ((crCount % 2) == 1) { // if odd dot com (place vertically)
            incr = gridLength; // set vertical increment
        }
        while ( !success & attempts++ < 200 ) { // main search loop (32)
            location = (int) (Math.random() * gridSize); // get random starting point
            //System.out.print(“ try “ + location);
            int x = 0; // nth position in dotcom to place
            success = true; // assume success
            while (success && x < crSize) { // look for adjacent unused spots
                if (grid[location] == 0) { // if not already used
                    coords[x++] = location; // save location
                    location += incr; // try ‘next’ adjacent
                    if (location >= gridSize){ // out of bounds - ‘bottom’
                        success = false; // failure
                    }
                    if (x>0 && (location % gridLength == 0)) { // out of bounds - right edge
                        success = false; // failure
                    }
                } else { // found already used location
                // System.out.print(“ used “ + location);
                    success = false; // failure
                }
            }
        } // end while
        int x = 0; // turn location into alpha coords
        int row = 0;
        int column = 0;
        // System.out.println(“\n”);
        while (x < crSize) {
            grid[coords[x]] = 1; // mark master grid pts. as ‘used’
            row = (int) (coords[x] / gridLength); // get row value
            column = coords[x] % gridLength; // get numeric column value
            temp = String.valueOf(alphabet.charAt(column)); // convert to alpha
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            //System.out.print(" coord "+x+" = " + alphaCells.get(x-1));
        }
        // System.out.println(“\n”);
        return alphaCells;
    }
}