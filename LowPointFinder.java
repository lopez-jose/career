/* The following program generates a rectangular map (with zero-based indices).
   Given an initial starting point, find the point with the lowest altitude that can
   be reached under these conditions:
   1) moving adjacent only sideways, up, or down (no diagonals)
   2) moving only when the altitude of the neighboring location is equal
      to or less than that of the current location

   If there are multiple points with the same lowest altitude that can be reached, select
   the path that encounters the steepest drop at the point of divergence. If each of the
   paths start out with the same drop in altitude, compare the drop at the next step ofT
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




public class LowPointFinder {
    static class gridPoint{
        int rowAdjust;
        int colAdjust;
        int difference;
        public gridPoint(int rowAdjust,int colAdjust, int difference)
        {
            this.rowAdjust = rowAdjust;
            this.colAdjust = colAdjust;
            this.difference = difference;
        }
        public void setPosition(int row, int col)
        {
            rowAdjust = row;
            colAdjust = col;
        }
    
        public int getRowAdjustment()
        {
            return rowAdjust;
        }
        public int getColAdjustment()
        {
            return colAdjust;
        }
        public void setDifference(int difference)
        {
            this.difference = difference;
        }
        public int getDifference()
        {
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

    public static void printLowestPoint(Map map, int iRow, int iColumn) {
        // implement this function (and any necessary helper code);
        // replace the ??? with the correct information
        System.out.println("The lowest reachable point occurs at "
                           +" ??? "+", "+" ??? "
                           +" with an altitude of "+" ??? ");

        System.out.println("Current Position = ("+iRow + "," + iColumn + ")");

        System.out.println("Current altitude = " + map.getAltitude(iRow,iColumn));
        boolean lowest = false;
        int currentRow = iRow;
        int currentColumn = iColumn;

        /* In a grid

                R--,C

        R,C--    R,C     R,C++

                R++,C

        */
        ArrayList <gridPoint> list = new ArrayList<gridPoint>();
        //hello
        //helloo
            if(currentRow>1 && currentRow<10 && currentColumn >1 && currentRow<10)
            {
                
                int currentValue = map.getAltitude(currentRow, currentColumn);
                int topValue = map.getAltitude(currentRow-1,currentColumn);
                int bottomValue = map.getAltitude(currentRow+1, currentColumn);
                int leftValue = map.getAltitude(currentRow, currentColumn-1);
                int rightValue = map.getAltitude(currentRow, currentColumn+1);


                //Location above
                System.out.println(map.getAltitude(currentRow-1, currentColumn));
                //Location below
                System.out.println(map.getAltitude(currentRow+1, currentColumn));
                //Location to the left
                System.out.println(map.getAltitude(currentRow, currentColumn-1));
                //Location to the right
                System.out.println(map.getAltitude(currentRow, currentColumn+1));
                
                int topDifference = currentValue -topValue;
                int bottomDifference = currentValue - bottomValue;
                int leftDifference = currentValue -leftValue;
                int rightDifference = currentValue - rightValue;

               
                gridPoint top = new gridPoint(-1,0,topDifference);
                gridPoint bottom = new gridPoint(1,0,bottomDifference);
                gridPoint left = new gridPoint(0,-1,leftDifference);
                gridPoint right = new gridPoint(0,1,rightDifference);
                
                list.add(top);
                list.add(bottom);
                list.add(left);
                list.add(right);
                //Collections.sort(list);
                System.out.println("Sorted List: " + list);
                


                
                
            }

        
    }

    public static void main(String args[]) {
        int rowCount;

        Map map = new Map(10, 10, 0);
        map.printMap();
        // From original call
        // printLowestPoint(map, 1, 9);

        printLowestPoint(map, 2, 2);

    }
}
