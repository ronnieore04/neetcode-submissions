class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> pairs = new Stack<>(); // entry = [height, index]
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            if (pairs.isEmpty()) {
                pairs.push(new int[]{heights[i], i});
                continue;
            }
            int[] top = pairs.peek();
            int start = i;
            if (top[0] < heights[i]) {
                pairs.push(new int[]{heights[i], i});
            } else if (top[0] == heights[i]) {
                continue;
            } else {
                while (!pairs.isEmpty() && heights[i] < pairs.peek()[0]) {
                    int[] popped = pairs.pop();
                    maxArea = Math.max(maxArea, popped[0] * (i - popped[1]));
                    start = popped[1];
                }
                pairs.push(new int[] {heights[i], start});
            }
        }

        while (!pairs.isEmpty()) {
            int[] popped = pairs.pop();
            maxArea = Math.max(maxArea, popped[0] * (heights.length - popped[1]));
        }

        return maxArea;
    }
}
