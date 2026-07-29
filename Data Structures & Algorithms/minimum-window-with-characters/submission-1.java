class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> freq_t = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq_t.put(c, freq_t.getOrDefault(c, 0) + 1);
        }

        int l = 0; int r; int length = Integer.MAX_VALUE;
        int have = 0, need = freq_t.size();
        int[] res = {-1, -1};
        HashMap<Character, Integer> freq_s = new HashMap<>();
        for (r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            freq_s.put(rightChar, freq_s.getOrDefault(rightChar, 0) + 1);

            if (freq_t.containsKey(rightChar) && freq_s.get(rightChar).equals(freq_t.get(rightChar))) {
                have++;
            }

            while (have == need) {
                if ((r-l+1 ) < length) {
                    length = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                freq_s.put(leftChar, freq_s.getOrDefault(leftChar, 0) - 1);

                if (freq_t.containsKey(leftChar) && freq_s.get(leftChar) < freq_t.get(leftChar)) {
                    have--;
                }

                l++;
            }
        }
        if (res[0] < 0 || res[1] < 0) return "";
        return s.substring(res[0], res[1]+1);
    }
}
