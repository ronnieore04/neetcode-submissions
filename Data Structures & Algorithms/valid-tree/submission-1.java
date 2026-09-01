class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        dfs(visited, adj, 0, -1);
        return visited.size() == n;
    }

    private boolean dfs(Set<Integer> visited, List<List<Integer>> adj, int i, int parent) {
        if (visited.contains(i)) return false;

        visited.add(i);
        for (int nei : adj.get(i)) {
            if (nei == parent) continue;
            if (!dfs(visited, adj, nei, i)) return false;
        }

        return true;
    }
}
