package _11_BackTracking.Algo2;

class IsValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    char ch = board[i][j];
                    board[i][j] = '.';
                    boolean ans = CHECK_IF_WE_CAN_PUT_THIS_VALUE(board, i, j, ch);
                    if (!ans) return false;
                    board[i][j] = ch;
                }
            }
        }
        return true;
    }


    private boolean CHECK_IF_WE_CAN_PUT_THIS_VALUE(char[][] board, int row, int col, char c) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            int subRow = ((row / 3) * 3) + (i / 3);
            int subCol = ((col / 3) * 3) + (i % 3);
            if (board[row][i] == c || board[i][col] == c || board[subRow][subCol] == c) {
                return false;
            }
        }
        return true;
    }
}