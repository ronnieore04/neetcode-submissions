class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // building adj list representation
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // counting indegrees
        int[] indegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegrees[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        // get all courses w no prereqs
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        // topological sort, starting with courses w no prereqs
        int finish = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            finish++;
            for (int c : adj.get(course)) {
                indegrees[c]--;
                if (indegrees[c] == 0) {
                    q.add(c);
                }
            }
        }
        return finish == numCourses;
    }
}
