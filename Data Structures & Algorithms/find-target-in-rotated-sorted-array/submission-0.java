class Solution {
    public int search(int[] nums, int target) {
        int l = 0; int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int pivot = l;
        int res = Arrays.binarySearch(nums, 0, pivot, target);
        if (res >= 0) return res;
        res = Arrays.binarySearch(nums, pivot, nums.length, target);
        return res >= 0 ? res : -1 ;
    }
}
