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
    //grid stores the altitude of reached points 
    static int[][] grid = new int[10][10];
    //finalPositions stores the final Position values
    static ArrayList<point> finalPositions = new ArrayList<point>();
    //previousPositions stores all the previous positions for each point on the grid
    static point[][] previousPositions = new point[10][10];
    

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
        public boolean getOccupied()
        {
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

    public static void finalPositionPrint(Map map, int[][] a, int iRow, int iColumn) {

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
    public static void printPointGrid(point[][] a) {

        System.out.println("Previous Positions\n-------------------------");
        System.out.println("      C0   C1   C2   C3   C4   C5   C6   C7   C8   C9");
        for (int i = 0; i <= 9; i++) {
            System.out.print("R" + i + "   ");
            for (int p = 0; p <= 9; p++) {
                if (a[i][p].getOccupied() == false)
                    System.out.print("     ");
                else
                    System.out.print(previousPositions[i][p].getRow() + ","+previousPositions[i][p].getCol()+ "  ");
            }
            System.out.println();
        }
    }
    public static void findLowestPoint(Map map, int iRow, int iColumn,int prevRow, int prevColumn) {
         // implement this function (and any necessary helper code);
        // replace the ??? with the correct information

        // final location in terms of

        point d = new point(prevRow,prevColumn,0, true);
        if(previousPositions[iRow][iColumn].getOccupied()==false)
        previousPositions[iRow][iColumn]=d;
        printPointGrid(previousPositions);
        
        boolean finalLocation = false;
        // int currentAltitude = 0 ;
        while (!finalLocation) {
            boolean withinBounds = (iRow >= 0) & (iRow <= 9) & (iColumn >= 0) & (iColumn <= 9);
            // Sets the current location to be a traversed location
            grid[iRow][iColumn] = 1;
            int currentAltitude = 0;
            if (withinBounds)
                currentAltitude = map.getAltitude(iRow, iColumn);

            // This takes into account out of bounds values and makes is so that the point
            int topAltitude = currentAltitude + 1;
            int bottomAltitude = currentAltitude + 1;
            int leftAltitude = currentAltitude + 1;
            int rightAltitude = currentAltitude + 1;

            // Now we will count the possible legal moves
            int legalMoves = 0;

            // Saves positions of objects
            ArrayList<pointAdjust> list = new ArrayList<pointAdjust>();

            // Prints visited locations
            //            finalPositionPrint(map, grid, 9, 9);

            // updates surrounding altitudes if they are within bounds
            // if they are not within bounds then we set the altitude to be 1 greater than
            // currentAltitude
            // to prevent access of out of bounds locations
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

            int topDifference = topAltitude - currentAltitude;
            int bottomDifference = bottomAltitude - currentAltitude;
            int leftDifference = leftAltitude - currentAltitude;
            int rightDifference = rightAltitude - currentAltitude;

            // Adds to legal moves if
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

            pointAdjust top = new pointAdjust(-1, 0, topDifference, topAltitude);
            pointAdjust bottom = new pointAdjust(1, 0, bottomDifference, bottomAltitude);
            pointAdjust left = new pointAdjust(0, -1, leftDifference, leftAltitude);
            pointAdjust right = new pointAdjust(0, 1, rightDifference, rightAltitude);

            list.add(top);
            list.add(bottom);
            list.add(left);
            list.add(right);

            // Shows current position values
            System.out.println("Current Position = (" + iRow + "," + iColumn + ")" + "\tCurrent Altitude ="
                    + map.getAltitude(iRow, iColumn) + "\tLegal Moves = " + legalMoves);

            // temporary variables to hold current position value
            int tempRow = iRow;
            int tempColumn = iColumn;

            // Sorts the list in ascending order according to the value of getDifference()
            Collections.sort(list, comparing(pointAdjust::getDifference));

            // checks the values up to legal moves amount

            for (int i = 0; i < legalMoves; i++) {
                tempRow = iRow + list.get(i).getRowAdjustment();
                tempColumn = iColumn + list.get(i).getColAdjustment();

                // true if value new location is within bounds
                withinBounds = (tempRow >= 0) & (tempRow <= 9) & (tempColumn >= 0) & (tempColumn <= 9);
                // if within bounds & new position has not been traversed
                // then recursively call printLowestPoint using new position
                if (withinBounds)
                      if (grid[tempRow][tempColumn] == 0)
                        findLowestPoint(map, tempRow, tempColumn,iRow,iColumn);
                        if(tempRow == iRow && tempColumn == iColumn)
                            System.out.println("MATCHED");

            }
            tempRow = iRow;
            tempColumn = iColumn;
            // This might cause issues because I get the first item on the list even if it
            // is not a good move.

            // adjust column final value
            tempRow += list.get(0).getRowAdjustment();
            tempColumn += list.get(0).getColAdjustment();
            boolean isValid = false;

            withinBounds = (tempRow >= 0) & (tempRow <= 9) & (tempColumn >= 0) & (tempColumn <= 9);
            if (withinBounds)
                isValid = (map.getAltitude(iRow, iColumn) >= map.getAltitude(tempRow, tempColumn));
            else
                isValid = false;
            if (withinBounds && grid[tempRow][tempColumn] == 0 && legalMoves > 0 && isValid) {
                // System.out.println("Future Position = (" + tempRow + "," + tempColumn + ")" +
                // "\t\tFuture Altitude =" + map.getAltitude(tempRow, tempColumn));
                iRow = tempRow;
                iColumn = tempColumn;

            } else {
                finalLocation = true;
                // System.out.println("End while loop");
            }
            // map.printMap();

        }
        point a = new point(iRow, iColumn, map.getAltitude(iRow, iColumn),false);
        finalPositions.add(a);
        // System.out.println("The lowest reachable point occurs at " + iRow + ", " +
        // iColumn + " with an altitude of "+ map.getAltitude(iRow, iColumn));

    }
    
    public static void printLowestPoint(Map map, int iRow, int iColumn) {
        for(int i =0; i <10; i++)
        {
            for(int p = 0; p < 10; p++)
            {
                point a = new point(0,0,0,false);
                previousPositions[i][p] = a;
            }
        }
       findLowestPoint(map,iRow,iColumn,iRow,iColumn);
       Collections.sort(finalPositions, comparing(point::getAltitude));
       point lowestPoint = finalPositions.get(0);
       
       int low = lowestPoint.getAltitude();
       boolean isEnd = false;
       int i = 1;
       point origin = new point(iRow,iColumn,map.getAltitude(iRow,iColumn),false);
       System.out.println("Lowest point row = " + lowestPoint.getRow() + "Lowest Point Column = " + lowestPoint.getCol());
       while(!isEnd)
       {
           if(finalPositions.get(i).getAltitude() == low)
           {
               System.out.println("Matching value at = (" +finalPositions.get(i).getRow() + "," + finalPositions.get(i).getCol()+ ")" );
               lowestPoint = findBestPoint(map,lowestPoint,finalPositions.get(i),origin);
                
           }else{
               isEnd = true;
           }
           i = i+1;
       }
       int lowRow = lowestPoint.getRow();
       int lowCol = lowestPoint.getCol();
       
       System.out
               .println("The lowest reachable point occurs at " + lowRow+ ", " + lowCol
                       + " with an altitude of " + map.getAltitude(lowRow,lowCol));
       


    }
    public static point findBestPoint(Map map, point a, point b,point c)
    {
        List<Integer> list1  =new ArrayList <Integer>();
        List<Integer> list2  =new ArrayList <Integer>();
        boolean isEnd = false;
        int rowA = a.getRow();
        int colA = a.getCol();
        int rowB = b.getRow();
        int colB = b.getCol();
        int rowOrigin = 0 ,colOrigin = 0;


        System.out.println("Row A = " + rowA + "Col A = " + colA);
        System.out.println("Row Origin = " + rowOrigin + "Col Origin = " + colOrigin);
        list1.add(a.getAltitude());
        list2.add(b.getAltitude());
        while(!isEnd)
        {
            if(rowA == rowOrigin && colA == colOrigin)
                break;
            int previousRow = previousPositions[rowA][colA].getRow();
            int previousCol = previousPositions[rowA][colA].getCol();
            System.out.println("Previous row = " + previousRow + "Previous Column = " + previousCol);
            int oldHeight = map.getAltitude(previousRow,previousCol);
            System.out.println(oldHeight);
            list1.add(oldHeight);
            rowA = previousRow;
            colA = previousCol;

        }
        isEnd = false;
        while(!isEnd)
        {
            if(rowB == rowOrigin && colB == colOrigin)
                break;
            int previousRow = previousPositions[rowB][colB].getRow();
            int previousCol = previousPositions[rowB][colB].getCol();
            System.out.println("Previous row = " + previousRow + "Previous Column = " + previousCol);
            int oldHeight = map.getAltitude(previousRow,previousCol);
            System.out.println(oldHeight);
            list2.add(oldHeight);
            rowB = previousRow;
            colB = previousCol;

        }
        Collections.reverse(list1);
        Collections.reverse(list2);

        int lengthLimit = list1.size();

        if(list1.size()>list2.size())
            lengthLimit = list2.size();
        System.out.print("Altitudes for Point a = ");
        for(int i = 0; i < list1.size();i++)
        {
            System.out.print(list1.get(i)+ " ");
        }   
        System.out.println();

        System.out.print("Altitudes for Point b = ");
        for(int i = 0; i < list2.size();i++)
        {
            System.out.print(list2.get(i)+ " ");
        }   
        System.out.println();

       boolean difference = false;

       int pos = 0;
    
       //adjust this to work with all matching values
       while(!isEnd)
       {
            if(list1.get(pos)!=list2.get(pos))
            {
                isEnd = true;
                difference = true;
            }

            if(pos<lengthLimit-1)
             pos++;
            else
                isEnd = true;
       }

       int differenceRowA = Math.abs(rowOrigin-rowA);
       int differenceColA = Math.abs(colOrigin-colA);


       int pointsA = differenceRowA+differenceColA;

       int differenceRowB = Math.abs(rowOrigin-rowB);
       int differenceColB = Math.abs(colOrigin-colB);

       int pointsB = differenceRowB + differenceColB;

       if(difference==true)
       {
        if(list1.get(pos)>list2.get(pos))
            return b;
        else 
            return a;
       }
       if(pointsA>pointsB)
            return b;
       else
            return a;
       
    }
    public static void main(String args[]) {



        Map map = new Map(10, 10, 0);
        map.printMap();


       
        // From original call
        // printLowestPoint(map, 1, 9);
        // printLowestPoint(map, 5, 4);
        // printLowestPoint(map, 2, 2);

        // printLowestPoint(map, 3, 2);
        //printLowestPoint(map, 3, 2);
        //findLowestPoint(map,1,2,0,0);

        //This one has the same ending height for two positions ()
        //findLowestPoint(map,8,3,0,0);
        printLowestPoint(map,3,2);
        //printLowestPoint(map,8,3);
        finalPositionPrint(map, grid, 9, 9);

    }
}
