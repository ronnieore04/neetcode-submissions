class Solution {
    public void solve(char[][] board) {
        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[board.length-1][c] == 'O') {
                dfs(board, board.length-1, c);
            }
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][board[0].length-1] == 'O') {
                dfs(board, r, board[0].length-1);
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length ||
            board[r][c] != 'O') {
                return;
        }
        board[r][c] = '#';
        dfs(board, r-1, c);
        dfs(board, r+1, c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);
    }
}
