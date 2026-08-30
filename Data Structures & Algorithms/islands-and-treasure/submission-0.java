class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Deque<int[]> q = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    q.add(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] coordinate = q.poll();
            int r = coordinate[0];
            int c = coordinate[1];
            
            for (int[] dir : directions) {
                int x = r + dir[0];
                int y = c + dir[1];
                if (x < 0 || x >= grid.length || 
                    y < 0 || y >= grid[0].length || 
                    grid[x][y] != 2147483647) {
                        continue;
                }
                grid[x][y] = grid[r][c]+1;
                q.offer(new int[]{x, y});
            }
        }
    }
}
