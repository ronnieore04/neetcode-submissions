class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxCount = 0, currCount = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                currCount = 1;
                int next = num + 1;
                while (set.contains(next)) {
                    currCount++;
                    next++;
                }
                maxCount = Math.max(currCount, maxCount);
            }
        }
        return maxCount;
    }
}
