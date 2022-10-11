package overthrow.communist.regimes;

import java.util.ArrayList;

public class OCRPlacer {
        private static final String alphabet = "abcdefg";
        private int gridLength = 7;
        private int gridSize = 49;
        private int[] grid = new int[gridSize];
        private int crCount = 0;

        public ArrayList<String> placeCR(int crSize) {
            ArrayList<String> alphaCells = new ArrayList<String>();
            String temp = null;
            int[] coords = new int[crSize];
            int attempts = 0;
            boolean success = false;
            int location = 0;
            crCount++;
            int incr = 1;
            if ((crCount % 2) == 1) {
                incr = gridLength;
            }
            while (!success & attempts++ < 200) {
                location = (int) (Math.random() * gridSize);
                int x = 0;
                success = true;
                while (success && x < crSize) {
                    if (grid[location] == 0) {
                        coords[x++] = location;
                        location += incr;
                    }
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)) {
                        success = false;
                    } else {
                        success = false;
                    }
                }
            }
            int x = 0;
            int row = 0;
            int column = 0;
            while (x < crSize) {
                grid[coords[x]] = 1;
                row = (int) (coords[x] / gridLength);
                column = coords[x] % gridLength;
                temp = String.valueOf(alphabet.charAt(column));
                alphaCells.add(temp.concat(Integer.toString(row)));
                x++;
            }
            return alphaCells;
        }
    }
