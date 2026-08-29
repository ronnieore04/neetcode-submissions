class Solution {
    public int trap(int[] height) {
        // edge case
        if (height.length == 1) {
            return 0;
        }
        
        // storing the max prefix to the left
        int[] maxLeft = new int[height.length];
        int leftMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            maxLeft[i] = leftMax;
        }

        // storing the max prefix to the right
        int[] maxRight = new int[height.length];
        int rightMax = 0;
        for (int i = height.length-1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            maxRight[i] = rightMax;
        }

        // summing up water caught
        // each index holds minimum between max Left/Right[i] - height[i]
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            water += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return water;
    }
}
