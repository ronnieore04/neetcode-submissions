class Solution {
    public int findDuplicate(int[] nums) {
        // two pointers
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (fast != slow) { // detecting cycle 
            // (2 * slow = fast)
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int slow2 = 0;
        while (true) {
            if (slow == slow2) {
                return slow2;
            }
            slow = nums[slow];
            slow2 = nums[slow2];
        }
    }
}
