class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ret = new LinkedList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for (int r = 0; r < heights.length; r++) {
            // left border -> pacific
            dfs(pacific, heights, r, 0);
            // right border -> atlantic
            dfs(atlantic, heights, r, heights[0].length-1);
        }

        for (int c = 0; c < heights[0].length; c++) {
            // top border -> pacific
            dfs(pacific, heights, 0, c);
            // bottom border -> atlantic
            dfs(atlantic, heights, heights.length-1, c);
        }

        // TO-DO: find intersection
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (atlantic[i][j] == true && pacific[i][j] == true) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }

        return ret;
    }

    private void dfs(boolean[][] flow, int[][] heights, int r, int c) {
        if (flow[r][c] == true) {
                return;
        }
        flow[r][c] = true;

        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if ((nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length) &&
                heights[r][c] <= heights[nr][nc]) {
                dfs(flow, heights, nr, nc);
            }
        }
    }
}
