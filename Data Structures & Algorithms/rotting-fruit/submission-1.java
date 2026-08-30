class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Deque<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int minute = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size(); // working in BFS layers
            for (int i = 0; i < size; i++) {
                int[] rotten = q.poll();
                int r = rotten[0];
                int c = rotten[1];

                for (int[] dir : directions) {
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if (x < 0 || x >= grid.length || 
                    y < 0 || y >= grid[0].length || 
                    grid[x][y] != 1) {
                        continue;
                    }
                grid[x][y] = 2;
                q.offer(new int[]{x, y});
                fresh--;
                }
            }
            minute++;

        }
        return fresh == 0 ? minute : -1;
    }
}
