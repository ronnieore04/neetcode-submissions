class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int width = heights.length - 1;
        int currArea = width * Math.min(heights[left], heights[right]);
        int maxArea = -1;
        while (width > 0) {
            currArea = width * Math.min(heights[left], heights[right]);
            maxArea = Math.max(currArea, maxArea);
            System.out.println(maxArea);
            if (heights[left] > heights[right]) {
                right = right - 1;
            } else {
                left = left + 1;
            }
            width--;
        }
        return maxArea;
    }
}
