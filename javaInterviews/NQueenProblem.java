public class NQueenProblem {
    final int N = 4; // This sets the nxn matrix size

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        // returns false if a queen cannot be placed in the row[]col[]
        for (i = 0; i < col; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // now we check the diagonals to see if there are collisions
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // now we check the lower diagonal on the left side
        for (i = row, j = col; j >= 0 && i <= N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
