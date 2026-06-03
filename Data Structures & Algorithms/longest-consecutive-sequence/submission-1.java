class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i] + 1);
            System.out.println("new entry: " + nums[i] + " " + (nums[i]+1));
        }

        int currMax = 1;
        int overallMax = 1;
        ArrayList<Integer> visited = new ArrayList<>();
        for (int item : map.keySet()) {
            if (visited.contains(item)) continue;
            System.out.println(item);
            while (map.containsKey(map.get(item))) {
                currMax += 1;
                System.out.println("currMax updated: " + currMax);
                item = map.get(item);
            }
            System.out.println("comparing currmax " + currMax + " overall " + overallMax);
                
            overallMax = Math.max(currMax, overallMax);
            currMax = 1;
        }
        overallMax = Math.max(currMax, overallMax);
        return overallMax;
    }
}
