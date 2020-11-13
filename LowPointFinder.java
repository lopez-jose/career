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
    // grid stores the altitude of reached points
    static int[][] grid = new int[10][10];
    // finalPositions stores the final Position values
    static ArrayList<point> finalPositions = new ArrayList<point>();
    // previousPositions stores all the previous positions for each point on the
    // grid
    static point[][] previousPositions = new point[10][10];
    static Scanner input = new Scanner(System.in);

    static class point {
        int row;
        int column;
        int altitude;
        boolean occupied;

        public point(int row, int column, int altitude, boolean occupied) {
            this.row = row;
            this.column = column;
            this.altitude = altitude;
            this.occupied = occupied;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return column;
        }

        public int getAltitude() {
            return altitude;
        }

        public boolean getOccupied() {
            return occupied;
        }
    }

    static class pointAdjust {
        int rowAdjust;
        int colAdjust;
        int difference;
        int altitude;

        public pointAdjust(int rowAdjust, int colAdjust, int difference, int altitude) {
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

                mGrid[0] = new int[] { 90, 90, 90, 90, 90, 90, 90, 90, 90, 99 };
                mGrid[1] = new int[] { 90, 90, 90, 60, 75, 90, 90, 90, 90, 99 };
                mGrid[2] = new int[] { 90, 90, 90, 71, 80, 90, 90, 90, 90, 99 };
                mGrid[3] = new int[] { 90, 90, 90, 80, 90, 90, 90, 90, 90, 99 };
                mGrid[4] = new int[] { 90, 90, 90, 90, 80, 90, 90, 90, 90, 99 };
                mGrid[5] = new int[] { 90, 90, 90, 90, 70, 90, 90, 90, 90, 99 };
                mGrid[6] = new int[] { 90, 90, 90, 90, 60, 90, 90, 90, 90, 99 };
                mGrid[7] = new int[] { 90, 90, 90, 90, 90, 90, 90, 90, 90, 99 };
                mGrid[8] = new int[] { 90, 90, 90, 90, 90, 90, 90, 90, 90, 99 };
                mGrid[9] = new int[] { 90, 90, 90, 90, 90, 90, 90, 90, 90, 99 };

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

    public static void finalPositionsPrint(Map map, int[][] a, int iRow, int iColumn) {

        System.out.println("\n\n---------------Final Positions----------------");

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

    public static void previousPositionsPrint(point[][] a) {

        System.out.println("\n\n---------------Previous Positions----------------");
        System.out.println("      C0   C1   C2   C3   C4   C5   C6   C7   C8   C9");
        for (int i = 0; i <= 9; i++) {
            System.out.print("R" + i + "   ");
            for (int p = 0; p <= 9; p++) {
                if (a[i][p].getOccupied() == false)
                    System.out.print("     ");
                else
                    System.out.print(previousPositions[i][p].getRow() + "," + previousPositions[i][p].getCol() + "  ");
            }
            System.out.println();
        }
    }

    public static void findLowestPoint(Map map, int iRow, int iColumn, int prevRow, int prevColumn) {

        boolean finalLocation = false;
        int currentAltitude = 0;
        boolean withinBounds = false;

        // saves the previous location of the point
        point previousPoint = new point(prevRow, prevColumn, 0, true);
        // Adjustment values for row,col for each surrounding location
        pointAdjust topAdjust, bottomAdjust, leftAdjust, rightAdjust;
        // altitude values for surrounding locations
        int topAltitude, bottomAltitude, leftAltitude, rightAltitude;

        if (previousPositions[iRow][iColumn].getOccupied() == false)
            previousPositions[iRow][iColumn] = previousPoint;
        // previousPositionsPrint(previousPositions);

        // int currentAltitude = 0 ;
        while (!finalLocation) {
            withinBounds = (iRow >= 0) & (iRow <= 9) & (iColumn >= 0) & (iColumn <= 9);
            // Sets the current location to be a traversed location
            grid[iRow][iColumn] = 1;
            currentAltitude = 0;
            if (withinBounds)
                currentAltitude = map.getAltitude(iRow, iColumn);

            // This takes into account out of bounds values and makes is so that the point
            topAltitude = currentAltitude + 1;
            bottomAltitude = currentAltitude + 1;
            leftAltitude = currentAltitude + 1;
            rightAltitude = currentAltitude + 1;

            // Now we will count the possible legal moves
            int legalMoves = 0;

            // Saves positions of objects
            ArrayList<pointAdjust> listAdjustments = new ArrayList<pointAdjust>();

            // Prints visited locations
            finalPositionsPrint(map, grid, 9, 9);

            // updates surrounding altitudes if they are within bounds
            if (iRow - 1 >= 0)
                topAltitude = map.getAltitude(iRow - 1, iColumn);
            else
                topAltitude = currentAltitude + 1;

            if (iRow + 1 <= 9)
                bottomAltitude = map.getAltitude(iRow + 1, iColumn);
            else
                bottomAltitude = currentAltitude + 1;

            if (iColumn - 1 >= 0)
                leftAltitude = map.getAltitude(iRow, iColumn - 1);
            else
                leftAltitude = currentAltitude + 1;

            if (iColumn + 1 <= 9)
                rightAltitude = map.getAltitude(iRow, iColumn + 1);
            else
                rightAltitude = currentAltitude + 1;

            // sets the difference between the surrounding altitudes and current altitude
            int topDifference = topAltitude - currentAltitude;
            int bottomDifference = bottomAltitude - currentAltitude;
            int leftDifference = leftAltitude - currentAltitude;
            int rightDifference = rightAltitude - currentAltitude;

            // Adds to legal moves if the difference is <=0
            if (topDifference <= 0)
                legalMoves++;
            if (bottomDifference <= 0)
                legalMoves++;
            if (leftDifference <= 0)
                legalMoves++;
            if (rightDifference <= 0)
                legalMoves++;

            if (legalMoves == 0) {
                finalLocation = true;

            }

            topAdjust = new pointAdjust(-1, 0, topDifference, topAltitude);
            bottomAdjust = new pointAdjust(1, 0, bottomDifference, bottomAltitude);
            leftAdjust = new pointAdjust(0, -1, leftDifference, leftAltitude);
            rightAdjust = new pointAdjust(0, 1, rightDifference, rightAltitude);

            listAdjustments.add(topAdjust);
            listAdjustments.add(bottomAdjust);
            listAdjustments.add(leftAdjust);
            listAdjustments.add(rightAdjust);

            // temporary variables to hold current position value
            int tempRow = iRow;
            int tempColumn = iColumn;

            // Sorts the listAdjustments in ascending order according to the value of
            // getDifference()
            Collections.sort(listAdjustments, comparing(pointAdjust::getDifference));

            // checks the values up to legal moves amount

            for (int i = 0; i < legalMoves; i++) {
                tempRow = iRow + listAdjustments.get(i).getRowAdjustment();
                tempColumn = iColumn + listAdjustments.get(i).getColAdjustment();

                // true if value new location is within bounds
                withinBounds = (tempRow >= 0) & (tempRow <= 9) & (tempColumn >= 0) & (tempColumn <= 9);
                // if within bounds & new position has not been traversed
                // then recursively call printLowestPoint using new position
                if (withinBounds)
                    if (grid[tempRow][tempColumn] == 0)
                        findLowestPoint(map, tempRow, tempColumn, iRow, iColumn);

            }
            tempRow = iRow;
            tempColumn = iColumn;
            // This might cause issues because I get the first item on the listAdjustments
            // even if it
            // is not a good move.

            // adjust column final value
            tempRow += listAdjustments.get(0).getRowAdjustment();
            tempColumn += listAdjustments.get(0).getColAdjustment();
            boolean isValid = false;

            withinBounds = (tempRow >= 0) & (tempRow <= 9) & (tempColumn >= 0) & (tempColumn <= 9);
            if (withinBounds)
                isValid = (map.getAltitude(iRow, iColumn) >= map.getAltitude(tempRow, tempColumn));
            else
                isValid = false;
            if (withinBounds && grid[tempRow][tempColumn] == 0 && legalMoves > 0 && isValid) {
                iRow = tempRow;
                iColumn = tempColumn;

            } else {
                finalLocation = true;

            }

        }
        point a = new point(iRow, iColumn, map.getAltitude(iRow, iColumn), false);
        finalPositions.add(a);

    }

    public static void printLowestPoint(Map map, int iRow, int iColumn) {
        for (int i = 0; i < 10; i++) {
            for (int p = 0; p < 10; p++) {
                point a = new point(0, 0, 0, false);
                previousPositions[i][p] = a;
            }
        }
        // Finds lowest reachable altitudes and saves them to finalPositions
        findLowestPoint(map, iRow, iColumn, iRow, iColumn);
        Collections.sort(finalPositions, comparing(point::getAltitude));

        // sets the lowestPoint values to finalPositions.get(0);
        point lowestPoint = finalPositions.get(0);

        int low = lowestPoint.getAltitude();
        boolean isEnd = false;
        int index = 1;
        point origin = new point(iRow, iColumn, map.getAltitude(iRow, iColumn), false);

        // while altitudes read are the same height os lowestPoint determine the actual
        // lowest point given criteria.
        while (!isEnd) {

            // if values matches lowestPoint then determine the best point
            if (finalPositions.get(index).getAltitude() == low) {
                lowestPoint = findBestPoint(map, lowestPoint, finalPositions.get(index), origin);

            } else {
                isEnd = true;
            }
            index = index + 1;
        }
        // Set lowRow lowCol to determined lowestPoint
        int lowRow = lowestPoint.getRow();
        int lowCol = lowestPoint.getCol();

        System.out.println("The lowest reachable point occurs at " + lowRow + ", " + lowCol + " with an altitude of "
                + map.getAltitude(lowRow, lowCol));

    }

    public static point findBestPoint(Map map, point a, point b, point c) {
        List<Integer> altitudesA = new ArrayList<Integer>();
        List<Integer> altitudesB = new ArrayList<Integer>();
        boolean isEnd = false;
        int rowA = a.getRow();
        int colA = a.getCol();
        int rowB = b.getRow();
        int colB = b.getCol();
        int rowOrigin = c.getRow(), colOrigin = c.getCol();
        boolean difference = false;
        int pos = 0;

        // used to determine difference in row, col from 0,0 for each point
        int differenceRowA = Math.abs(rowOrigin - rowA);
        int differenceColA = Math.abs(colOrigin - colA);

        int differenceRowB = Math.abs(rowOrigin - rowB);
        int differenceColB = Math.abs(colOrigin - colB);
        // used to determine lowest point
        int pointsA = differenceRowA + differenceColA;
        int pointsB = differenceRowB + differenceColB;

        altitudesA.add(a.getAltitude());
        altitudesB.add(b.getAltitude());

        // Stores altitudes of previousPositions in altitudesA or altitudes B

        // I'm infinite looping on in these lines.

        // System.out.println("Current Position = (" + rowA + ","+colA+")" +
        // "Altitude="+a.getAltitude());

        while (!isEnd) {
            if (rowA == rowOrigin && colA == colOrigin)
                break;
            int previousRow = previousPositions[rowA][colA].getRow();
            int previousCol = previousPositions[rowA][colA].getCol();
            int oldHeight = map.getAltitude(previousRow, previousCol);
            altitudesA.add(oldHeight);
            rowA = previousRow;
            colA = previousCol;

        }
        isEnd = false;
        while (!isEnd) {
            if (rowB == rowOrigin && colB == colOrigin)
                break;
            int previousRow = previousPositions[rowB][colB].getRow();
            int previousCol = previousPositions[rowB][colB].getCol();
            int oldHeight = map.getAltitude(previousRow, previousCol);

            altitudesB.add(oldHeight);
            rowB = previousRow;
            colB = previousCol;

        }

        // Sorts lists
        Collections.reverse(altitudesA);
        Collections.reverse(altitudesB);

        // sets length limit
        int lengthLimit = altitudesA.size();
        if (altitudesA.size() > altitudesB.size())
            lengthLimit = altitudesB.size();

        // checks if there is a difference between altitudes, if so then end loop
        while (!isEnd) {
            if (altitudesA.get(pos) != altitudesB.get(pos)) {
                isEnd = true;
                difference = true;
            }

            if (pos < lengthLimit - 1)
                pos++;
            else
                isEnd = true;
        }

        // if there is a difference in Altitude return the correct point
        if (difference == true) {
            if (altitudesA.get(pos) > altitudesB.get(pos))
                return b;
            else
                return a;
        }

        // if there is no difference in altitude, then determine correct point based on
        // points

        if (pointsA > pointsB)
            return b;
        else
            return a;

    }

    public static void main(String args[]) {

        Map map = new Map(10, 10, 0);

        map.printMap();
        printLowestPoint(map, 3, 4);

        finalPositionsPrint(map, grid, 9, 9);
        previousPositionsPrint(previousPositions);

    }
}
