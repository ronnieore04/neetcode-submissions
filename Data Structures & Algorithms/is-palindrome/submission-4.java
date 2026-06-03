class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        s = sb.toString();
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }
        return isPalindrome(s, 0, s.length()-1);
    }

    public boolean isPalindrome(String s, int start, int end) {
        if (s.charAt(start) != s.charAt(end)) return false;
        if (start >= end) return true;
        else return isPalindrome(s, start+1, end-1);
    }
}
