class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            sb.append(length);
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new LinkedList<>();
        int i = 0;
        int j;

        while (i < str.length()) {
            j = i;
            // extract size
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j)); // up to '#' (not inclusive)

            // extract word
            String word = str.substring(j+1, j+length+1); // exclude '#', +1 so pointer ends at next number
            strs.add(word);

            i = j + length + 1; // starts at first digit of next size
            
        }
        return strs;
    }
}
