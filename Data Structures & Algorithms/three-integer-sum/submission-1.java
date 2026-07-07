class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        int i; int l; int r;
        for (i = 0 ; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) { // check no duplicates
                continue;
            }
            l = i+1; r = nums.length-1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) { // entry found
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; r--;
                    // prevent duplicates
                    while (l < r && nums[l] == nums[l-1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) { // too big
                    r--;
                } else {
                    l++;
                }
            }
        }
        return list;
    }
}
