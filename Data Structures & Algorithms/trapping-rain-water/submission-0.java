class Solution {
    public int trap(int[] height) {
        if (height.length == 1) {
            return 0;
        }
        
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        maxLeft[0] = 0;
        for(int i = 1; i < height.length; i++) {
            int currMax = height[i-1];
            maxLeft[i] = Math.max(currMax, maxLeft[i-1]);
        }

        maxRight[maxRight.length-1] = 0;
        for(int i = maxRight.length-2; i >= 0; i--) {
            int currMax = height[i+1];
            maxRight[i] = Math.max(currMax, maxRight[i+1]);
        }

        int[] minLR = new int[height.length];
        for(int i = 0; i < height.length; i++) {
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            sum += Math.max(0, minLR[i] - height[i]);
        }
        
        return sum;
    }
}
