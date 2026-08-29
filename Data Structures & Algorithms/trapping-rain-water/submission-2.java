class Solution {
    public int trap(int[] height) {
        // edge case
        if (height.length == 1) {
            return 0;
        }
        
        // two pointers
        int l = 0, r = height.length-1;
        int water = 0;
        int leftMax = height[l], rightMax = height[r];
        
            while (l < r) {
                if (leftMax < rightMax) {
                    l++;
                    leftMax = Math.max(leftMax, height[l]);
                    water += leftMax - height[l];
                } else {
                    r--;
                    rightMax = Math.max(rightMax, height[r]);
                    water += rightMax - height[r];
                }
            }
        return water;
    }
}
