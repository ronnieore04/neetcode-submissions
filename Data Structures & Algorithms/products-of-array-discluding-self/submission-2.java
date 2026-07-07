class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i=0; i<ret.length; i++) {
            ret[i] = 1;
        }

        int prefix = 1;
        for (int i=0; i<ret.length; i++) {
            ret[i] = prefix;
            prefix = nums[i] * prefix;
        }
        int suffix = 1;
        for (int i=ret.length-1; i>=0; i--) {
            ret[i] = ret[i] * suffix;
            suffix = nums[i] * suffix;
        }

        return ret;
    }
}

// [1, 2, 3, 4] (my strat, which obviously sucks)
// prefix: [1, 1, 2, 6]
// suffix: [6, 2, 1, 1]
// res: [48, 24, 12, 8]

// [1, 2, 3, 4]
// instead of storing each individual prefix,
// just update store the new one at the end of the iteration
// i=0 prefix=1; i=1 prefix=2; i=2 prefix=6, i=3 prefix=36 (whatever)
// res: [1, 1, 2, 6]
// now for suffix, we're using the prefixes and also reverse 
// i=3 suffix=4; i=2 suffix=12; i=1 suffix=24; i=0 suffix=24 (whatever)
