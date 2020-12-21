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

    }
}
