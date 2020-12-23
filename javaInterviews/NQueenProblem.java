import org.junit.Test;
import static org.junit.Assert.assertTrue;

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
            if (board[row][i] == 1) {
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
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    // A recursive utlity function to solve N Queen problem
    boolean solveNQUtil(int board[][], int col) {
        if (col >= N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1) == true) {
                    return true;
                }

                board[i][col] = 0; // backtrack
            }
        }
        return false;
    }

    boolean solveNQ() {
        int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        if (solveNQUtil(board, 0) == false) {
            System.out.println("Solution does not exist");
            return false;
        }
        // board has been modified to fit the standard laytout
        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }

    @Test
    public void givenBoardwithIncorrectly_Placed_Queens() {
        NQueenProblem Queen = new NQueenProblem();
        int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        assertTrue(Queen.isSafe(board, 0, 0));
    }
}
