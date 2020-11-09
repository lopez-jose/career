/* The following program generates a rectangular map (with zero-based indices).
   Given an initial starting point, find the point with the lowest altitude that can
   be reached under these conditions:
   1) moving adjacent only sideways, up, or down (no diagonals)
   2) moving only when the altitude of the neighboring location is equal
      to or less than that of the current location

   If there are multiple points with the same lowest altitude that can be reached, select
   the path that encounters the steepest drop at the point of divergence. If each of the
   paths start out with the same drop in altitude, compare the drop at the next step of
   each route (and if those are the same, continue comparing until a difference is found).
   If there is more than one path with the exact same ending altitude and same drops
   along the way, favor points whose row is closest to R0; with points along the same row,
   favor points whose columns are closest to C0.

Sample map:

      C0  C1  C2  C3
  R0  67  72  93   5
  R1  38  53  71  48
  R2  64  56  52  44
  R3  44  51  57  49

Starting at R0, C1 should end up at R1, C0.
Starting at R1, C3 should end up at R0, C3.
Starting at R3, C2 should end up at R2, C3 since the drop from 57 to 49 is steeper than the drop from 57 to 51 when comparing R3, C0 to R2, C3.

Implement printLowestPoint to correctly print the answer.

*/

import java.util.Random;
import java.util.*;
import static java.util.Comparator.comparing;

public class LowPointFinder {
    static int[][] grid = new int[10][10];
    static Scanner input = new Scanner(System.in);
    static ArrayList<point> listb = new ArrayList<point>();
    static class point {
        int row;
        int column;
        int altitude;
    

    public point(int row, int column, int altitude)
        {
            this.row = row;
            this.column = column;
            this.altitude = altitude;
        }
        public int getRow()
        {
            return row;
        }
        public int getCol()
        {
            return column;
        }
        public int getAltitude()
        {
            return altitude;
        }
    }

    static class gridPoint {
        int rowAdjust;
        int colAdjust;
        int difference;
        int altitude;

        public gridPoint(int rowAdjust, int colAdjust, int difference, int altitude) {
            this.rowAdjust = rowAdjust;
            this.colAdjust = colAdjust;
            this.difference = difference;
            this.altitude = altitude;
        }

        public int getAltitude() {
            return altitude;
        }

        public void setPosition(int row, int col) {
            rowAdjust = row;
            colAdjust = col;
        }

        public int getRowAdjustment() {
            return rowAdjust;
        }

        public int getColAdjustment() {
            return colAdjust;
        }

        public void setDifference(int difference) {
            this.difference = difference;
        }

        public int getDifference() {
            return difference;
        }

    }

    public static class Map {
        // do not change anything in the Map class
        private int mGrid[][] = null;

        public int getNumRows() {
            return mGrid.length;
        }

        public int getNumColumns() {
            return mGrid[0].length;
        }

        public int getAltitude(int iRow, int iColumn) {
            return mGrid[iRow][iColumn];
        }

        public void printMap() {
            StringBuilder sbRow = new StringBuilder("    ");
            for (int i = 0; i < mGrid[0].length; i++) {
                String strCell = String.format("%4s", "C" + i);
                sbRow.append(strCell);
            }
            System.out.println(sbRow.toString());
            for (int i = 0; i < mGrid.length; i++) {
                String strCell = String.format("%4s", "R" + i);
                sbRow = new StringBuilder(strCell);
                for (int j = 0; j < mGrid[0].length; j++) {
                    strCell = String.format("%4d", getAltitude(i, j));
                    sbRow.append(strCell);
                }
                System.out.println(sbRow.toString());
            }
        }

        private int changeAltitude(int iAltitude, Random random) {
            return iAltitude + random.nextInt(11) - 5;
        }

        public Map(int iNumRows, int iNumColumns, int iRandomSeed) {
            mGrid = new int[iNumRows][iNumColumns];
            Random random = new Random(iRandomSeed);
            for (int i = 0; i < iNumRows; i++) {
                for (int j = 0; j < iNumColumns; j++) {
                    int iAltitude = 0;
                    if (i == 0) {
                        iAltitude = random.nextInt(101);
                    } else {
                        int iSideAltitude = 0;
                        if (j == 0)
                            iSideAltitude = random.nextInt(101);
                        else
                            iSideAltitude = getAltitude(i, j - 1);
                        int iTopAltitude = getAltitude(i - 1, j);
                        iAltitude = (changeAltitude(iSideAltitude, random) + changeAltitude(iTopAltitude, random)) / 2;
                        if (iAltitude < 0)
                            iAltitude = 0;
                        else if (iAltitude > 100)
                            iAltitude = 100;
                    }
                    mGrid[i][j] = iAltitude;
                }
            }
        }
    }

    public static void printGrid(Map map, int[][] a, int iRow, int iColumn) {

        System.out.println("Current path taken.");
        System.out.println("      C0  C1  C2  C3  C4  C5  C6  C7  C8 C9");
        for (int i = 0; i <= 9; i++) {
            System.out.print("  R" + i + "  ");
            for (int p = 0; p <= 9; p++) {
                if (a[i][p] == 0)
                    System.out.print(".   ");
                else
                    System.out.print(map.getAltitude(i, p) + "  ");
            }
            System.out.println();
        }
    }
    public static point findLowestPoint(Map map, int iRow, int iColumn)
    {
        point a = new point(0,0,0);

        return a;
    }
    public static void printLowestPoint(Map map, int iRow, int iColumn) {
        // implement this function (and any necessary helper code);
        // replace the ??? with the correct information

        int currentRow = iRow;
        int currentColumn = iColumn;

        boolean finalLocation = false;

        while (!finalLocation) {

            grid[currentRow][currentColumn] = 1;
            boolean withinBounds = (currentRow >= 0) & (currentRow <= 9) & (currentColumn >= 0) & (currentColumn <= 9);
            int currentAltitude = 0;
            if (withinBounds)
                currentAltitude = map.getAltitude(currentRow, currentColumn);

            // This takes into account out of bounds values and makes is so that the point
            // never goes here.
            int topAltitude = currentAltitude + 1;
            int bottomAltitude = currentAltitude + 1;
            int leftAltitude = currentAltitude + 1;
            int rightAltitude = currentAltitude + 1;

            // Now we will count the possible legal moves
            int legalMoves = 0;
            //Saves positions of objects
            ArrayList<gridPoint> list = new ArrayList<gridPoint>();
            list.clear();
            printGrid(map, grid, 9, 9);
            if (currentRow - 1 >= 0)
                topAltitude = map.getAltitude(currentRow - 1, currentColumn);

            if (currentRow + 1 <= 9)
                bottomAltitude = map.getAltitude(currentRow + 1, currentColumn);

            if (currentColumn - 1 >= 0)
                leftAltitude = map.getAltitude(currentRow, currentColumn - 1);

            if (currentColumn + 1 <= 9)
                rightAltitude = map.getAltitude(currentRow, currentColumn + 1);

            // System.out.println("Top Altitude =" + topAltitude + "\tBottom Altitude =" +
            // bottomAltitude
            // + "Left Altitude =" + leftAltitude + "\tRight Altitude= " + rightAltitude);

            int topDifference = topAltitude - currentAltitude;
            int bottomDifference = bottomAltitude - currentAltitude;
            int leftDifference = leftAltitude - currentAltitude;
            int rightDifference = rightAltitude - currentAltitude;

            if (topDifference <= 0)
                legalMoves++;
            if (bottomDifference <= 0)
                legalMoves++;
            if (leftDifference <= 0)
                legalMoves++;
            if (rightDifference <= 0)
                legalMoves++;

            if (legalMoves == 0)
                finalLocation = true;
            // have to adjust this so that it doesn't continously add new points
            gridPoint top = new gridPoint(-1, 0, topDifference, topAltitude);
            gridPoint bottom = new gridPoint(1, 0, bottomDifference, bottomAltitude);
            gridPoint left = new gridPoint(0, -1, leftDifference, leftAltitude);
            gridPoint right = new gridPoint(0, 1, rightDifference, rightAltitude);

            list.add(top);
            list.add(bottom);
            list.add(left);
            list.add(right);

            // Sorts the list according to the value of getDifference()
            Collections.sort(list, comparing(gridPoint::getDifference));

            // Shows current position values
            System.out.println("Current Position = (" + currentRow + "," + currentColumn + ")" + "\tCurrent Altitude ="
                    + map.getAltitude(currentRow, currentColumn) + "\tLegal Moves = " + legalMoves);

            // this is the for loop that get distances of each position surrounding
            // I have a legal moves count

            //input.nextLine();
            int tempRow = currentRow;
            int tempColumn = currentColumn;

            for (int i = 0; i < list.size(); i++) {
                int altitudeDifference = list.get(i).getDifference();
                // System.out.println("Next Position Altitude =" + list.get(i).getAltitude()+
                // "\tDifference = " + altitudeDifference + "\n\n");
                if (altitudeDifference <= 0 && legalMoves > 1) {

                    tempRow = currentRow + list.get(i).getRowAdjustment();
                    tempColumn = currentColumn + list.get(i).getColAdjustment();
                    // This might cause an issue
                    withinBounds = (tempRow >= 0) & (tempRow <= 9) & (tempColumn >= 0) & (tempColumn <= 9);
                    if (withinBounds) {
                        boolean isValid = (map.getAltitude(currentRow, currentColumn) >= map.getAltitude(tempRow,
                                tempColumn));
                        if (isValid && grid[tempRow][tempColumn] == 0)
                            printLowestPoint(map, tempRow, tempColumn);
                    }
                }
            }

            tempRow = currentRow;
            tempColumn = currentColumn;
            // This might cause issues because I get the first item on the list even if it
            // is not a good move.

            tempRow += list.get(0).getRowAdjustment();
            tempColumn += list.get(0).getColAdjustment();
            boolean isValid;

            withinBounds = (tempRow >= 0) & (tempRow <= 9) & (tempColumn >= 0) & (tempColumn <= 9);
            if (withinBounds)
                isValid = (map.getAltitude(currentRow, currentColumn) >= map.getAltitude(tempRow, tempColumn));
            else
                isValid = false;
            if (withinBounds && grid[tempRow][tempColumn] == 0 && legalMoves > 0 && isValid) {
                System.out.println("Future Position = (" + tempRow + "," + tempColumn + ")" + "\t\tFuture Altitude ="
                        + map.getAltitude(tempRow, tempColumn));
                currentRow = tempRow;
                currentColumn = tempColumn;

            } else {
                finalLocation = true;
                System.out.println("End while loop");
            }
            // map.printMap();

        }
        point a = new point(currentRow,currentColumn,map.getAltitude(currentRow,currentColumn));
        listb.add(a);
        System.out.println("The lowest reachable point occurs at " + currentRow + ", " + currentColumn
                + " with an altitude of " + map.getAltitude(currentRow, currentColumn));

    }

    public static void main(String args[]) {

        Map map = new Map(10, 10, 0);
        map.printMap();
        // From original call
        // printLowestPoint(map, 1, 9);
        // printLowestPoint(map, 5, 4);
        // printLowestPoint(map, 2, 2);
        
        printLowestPoint(map, 3, 2);
        Collections.sort(listb, comparing(point::getAltitude));
        System.out.println("The lowest reachable point occurs at " + listb.get(0).getRow()+ ", " + listb.get(0).getCol()
                + " with an altitude of " + map.getAltitude(listb.get(0).getRow(), listb.get(0).getCol()));

        

    }
}
