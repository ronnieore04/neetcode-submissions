class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) { // can compare chars 
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true; // match found
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false; // out of bounds
        }
        if (board[i][j] != word.charAt(index) || board[i][j] == '#') {
            return false; // mismatch
        }
        // word stores which letter we are at
        board[i][j] = '#'; // marking to prevent using more than once
        boolean ret = 
            dfs(board, word, i+1, j, index+1) ||
            dfs(board, word, i-1, j, index+1) ||
            dfs(board, word, i, j+1, index+1) ||
            dfs(board, word, i, j-1, index+1);
        board[i][j] = word.charAt(index);
        return ret;
    }
}
