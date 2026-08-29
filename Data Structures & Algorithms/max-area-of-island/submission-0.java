class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        int currArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, r, c));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c>= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        
        return 1 + 
            dfs(grid, visited, r+1, c) +
            dfs(grid, visited, r-1, c) +
            dfs(grid, visited, r, c+1) +
            dfs(grid, visited, r, c-1);
        
    }
}
