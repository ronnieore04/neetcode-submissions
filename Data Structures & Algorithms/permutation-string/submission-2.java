class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // edge cases
        if (s1.length() > s2.length()) return false;

        int[] s1_counts = new int[26];
        for (char c : s1.toCharArray()) {
            s1_counts[c-'a']++;
        }

        int[] s2_counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2_counts[c-'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1_counts[i] == s2_counts[i]) matches++;
        }

        // fixed sliding window of size s1.length()
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) return true;

            int i = s2.charAt(r) - 'a';
            s2_counts[i]++;
            if (s1_counts[i] == s2_counts[i]) matches++;
            else if (s1_counts[i] == s2_counts[i] - 1) matches--;

            i = s2.charAt(l) - 'a';
            s2_counts[i]--;
            if (s1_counts[i] == s2_counts[i]) matches++;
            else if (s1_counts[i] == s2_counts[i] + 1) matches--;

            l++;
        }
        return matches==26;
    }
}