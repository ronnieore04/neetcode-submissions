class Solution {
    public int maxArea(int[] heights) {
        int width = heights.length - 1;
        int l = 0, r = heights.length - 1;
        int maxArea = Math.min(heights[l], heights[r]) * width;
        
        int currArea;
        while (width > 0) {
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
            width--;
            currArea = width * Math.min(heights[l], heights[r]);
            maxArea = Math.max(maxArea, currArea);
        }
        
        return maxArea;
    }
}
