class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aleft, bleft, aright, bright;
        int half = (nums1.length + nums2.length + 1) / 2;
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        if (nums1.length <= nums2.length) {
            int l = 0, r = nums1.length;
            while (l <= r) {
                int amid = l + (r-l) / 2;
                int bmid = half - amid;
                
                aleft = (amid == 0) ? Integer.MIN_VALUE : nums1[amid - 1];
                aright = (amid >= nums1.length) ? Integer.MAX_VALUE : nums1[amid];
                bleft = (bmid <= 0) ? Integer.MIN_VALUE : nums2[bmid - 1];
                bright = (bmid >= nums2.length) ? Integer.MAX_VALUE : nums2[bmid];

                if (aleft <= bright && bleft <= aright) {
                    if (((nums1.length + nums2.length) % 2) == 0) {
                        return (double)(Math.max(aleft, bleft) + Math.min(aright, bright))/2.0;
                    } else {
                        return (double)(Math.max(aleft, bleft));
                    }
                } else if (bleft > aright) {
                    l = amid + 1;
                } else {
                    r = amid - 1;
                }
            }
        }
        return 0.0;
    }
}