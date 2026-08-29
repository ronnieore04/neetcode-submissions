class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        // number       1 2 3 4 5 6 7 8 9
        // which bit    0 1 2 3 4 5 6 7 8

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                // extract number -> corresponding bit
                if (board[r][c] == '.') continue;
                int val = board[r][c] - '1';

                if ((rows[r] & (1 << val)) > 0 ||
                    (cols[c] & (1 << val)) > 0 ||
                    (squares[(r/3) * 3 + (c/3)] & (1 << val)) > 0
                    ) return false;
                rows[r] |= (1 << val);
                cols[c] |= (1 << val);
                squares[(r/3)*3 + (c/3)] |= (1 << val);
            }
        }

        return true;
    }
}
