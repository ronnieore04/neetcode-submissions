class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ret = new int[numCourses];

        // create map of courses
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // create indegrees of prereqs
        int[] indegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegrees[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        // start queue w/ courses w/ no prereqs
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        int finish = 0, index = numCourses - 1;
        while (!q.isEmpty()) {
            int course = q.poll();
            ret[index--] = course;
            for (int nei : adj.get(course)) {
                indegrees[nei]--;
                if (indegrees[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if (index >= 0) return new int[]{};
        else return ret;
    }
}
