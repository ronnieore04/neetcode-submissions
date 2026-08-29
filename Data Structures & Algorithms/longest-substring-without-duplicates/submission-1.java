class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int l = 0, r = 0, length = 1;

        // character, most recent index
        Map<Character, Integer> map = new HashMap<>(); 
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c) + 1);
            }

            map.put(c, r);
            int window = r - l + 1;
            length = Math.max(window, length);
            r++;
        }
        return length;
    }
}

// alsdskjfei
// abbcdefafb
// keep extending the window if a new character is found
// shift the window and delete entry if a duplicate character is found

