class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        int fmax = 0, ret = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            fmap.put(c, fmap.getOrDefault(c, 0) + 1);
            fmax = Math.max(fmax, fmap.get(c));

            while (r-l+1 - fmax > k) {
                fmap.put(s.charAt(l), fmap.get(s.charAt(l)) - 1);
                l++;
            }
            ret = Math.max(ret, r-l+1);
        }

        return ret;

    }
}

// k replacements have to be less than (window size - fmax)
// window size = r - l + 1