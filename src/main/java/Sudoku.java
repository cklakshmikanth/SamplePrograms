public class Sudoku {

    private static final int GRID_SIZE = 9;


    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 5, 0, 0, 0, 0, 0, 0},
                {7, 0, 4, 0, 9, 0, 0, 1, 2},
                {0, 1, 0, 0, 0, 4, 3, 0, 0},
                {5, 6, 0, 4, 0, 7, 0, 0, 3},
                {0, 4, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 6, 8, 3, 5, 0, 0},
                {9, 2, 0, 0, 7, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 9, 2, 0, 6},
                {0, 7, 3, 0, 0, 0, 9, 0, 0}
        };

        solveSudoku(board);

        for(int i = 0; i < GRID_SIZE; i++) {
            for(int j = 0; j < GRID_SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isNumberPresentInRow(int[][] board, int number, int row) {
        for(int i=0; i < GRID_SIZE; i++) {
            if(board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberPresentInColumn(int[][] board, int number, int column) {
        for(int i=0; i < GRID_SIZE; i++) {
            if(board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberPresentInBox(int[][] board, int number, int row, int column) {
        int rowIndexOfBox = row - row % 3;
        int columnIndexOfBox = column - column % 3;
        /*int rowIndexOfBox = (row / 3) * 3;
        int columnIndexOfBox = (column / 3) * 3;*/
        for(int i = rowIndexOfBox; i < rowIndexOfBox + 3; i++) {
            for(int j = columnIndexOfBox; j < columnIndexOfBox + 3; j++) {
                if(board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPlacementValid(int[][] board, int number, int row, int column) {
        return !isNumberPresentInBox(board, number, row, column) &&
                !isNumberPresentInColumn(board, number, column) &&
                !isNumberPresentInRow(board, number, row);
    }

    private static boolean solveSudoku(int[][] board) {
        for(int i = 0; i < GRID_SIZE; i++) {
            for(int j = 0; j < GRID_SIZE; j++) {
                if(board[i][j] == 0) {
                    for (int k = 1; k <= GRID_SIZE; k++) {
                        if(isPlacementValid(board, k, i, j)) {
                            board[i][j] = k;
                            if(solveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
