class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // O(nlogn)
        List<List<Integer>> ret = new LinkedList<>();

        int i = 0, l, r;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) {
                i++; continue;
            }

            l = i+1; r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    List<Integer> entry = new LinkedList<>();
                    entry.add(nums[i]);
                    entry.add(nums[l]);
                    entry.add(nums[r]);
                    ret.add(entry);
                    l++; r--;
                    while (l < r && nums[l] == nums[l-1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;
                }
            }
            i++;
        }
        return ret;
    }
}
