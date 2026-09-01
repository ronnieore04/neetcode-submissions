class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int num = 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, adj, i);
                num++;
            }
        }
        return num;
    }

    private void dfs(boolean[] visited, List<List<Integer>> adj, int i) {
        visited[i] = true;
        for (int node : adj.get(i)) {
            if (!visited[node]) dfs(visited, adj, node);
        }
    }
}
