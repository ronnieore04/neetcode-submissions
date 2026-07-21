class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1CharCounts = new int[26];
        for (char c : s1.toCharArray()) {
            s1CharCounts[c - 'a']++;
        }

        int l = 0, r = 0;
        int[] s2CharCounts = new int[26];
        while (r < s2.length()) {
            char c = s2.charAt(r);
            if (r < s1.length()) {
                s2CharCounts[c - 'a']++;
                r++;
            } else {
                if (Arrays.equals(s1CharCounts, s2CharCounts)) {
                    return true;
                } else {
                    s2CharCounts[s2.charAt(l) - 'a']--;
                    l++;
                    s2CharCounts[s2.charAt(r) - 'a']++;
                    r++;
                }
            }
        }
        return Arrays.equals(s1CharCounts, s2CharCounts);
    }
}

// set up char array of counts for s1
// set up window of s1 length, for s2
// update counts based on fixed window size, 
//  and if the arrays match in counts, return true