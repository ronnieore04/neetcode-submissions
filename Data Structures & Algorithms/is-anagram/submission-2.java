class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s_freq = new int[26];

        for (char c : s.toCharArray()) {
            s_freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            s_freq[c - 'a']--;
        }

        for (int i=0; i < s_freq.length; i++) {
            if (s_freq[i] != 0) return false;
        }
        return true;
    }
}
