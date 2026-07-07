class Solution {

    public String encode(List<String> strs) {
        StringBuilder strb = new StringBuilder();
        for (String str : strs) {
            int size = str.length();
            strb.append(size);
            strb.append("#");
            strb.append(str);
        }
        return strb.toString();
    }

    public List<String> decode(String str) {
        LinkedList<String> strings = new LinkedList<>();
        int i = 0;
        
        while (i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            
            int length = Integer.parseInt(str.substring(i, j));
            strings.add(str.substring(j+1, j+length+1));

            i = j+length+1;
        }

        return strings;
    }
}
