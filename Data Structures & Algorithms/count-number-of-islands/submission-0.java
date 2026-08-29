class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '0') {
                    visited[r][c] = true;
                }
                else if (!visited[r][c]) {
                    dfs(grid, visited, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] == '0') return;
        visited[r][c] = true;

        dfs(grid, visited, r+1, c);
        dfs(grid, visited, r-1, c);
        dfs(grid, visited, r, c+1);
        dfs(grid, visited, r, c-1);
    }
}
