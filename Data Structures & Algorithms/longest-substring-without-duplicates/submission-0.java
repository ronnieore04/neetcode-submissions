class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int l = 0; int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c) + 1);
            }

            map.put(c, r);
            int currLength = r - l + 1;
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}

// alsdskjfei
// abcdefafb
// keep extending the window if a new character is found
// shift the window and delete entry if a duplicate character is found

