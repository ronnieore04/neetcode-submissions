class Solution {

    public List<String> letterCombinations(String digits) {
        // setting up map of digit --> leters
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // setting up the search
        List<String> res = new LinkedList<>();

        // edge case
        if (digits.equals("")) return res;
        
        StringBuilder sb = new StringBuilder();
        backtrack(digits, sb, 0, res, map);
        return res;
    }

    public void backtrack(String digits, StringBuilder curr, int index, List<String> res, Map<Character, String> map) {
        if (digits.length() == curr.length()) {
            res.add(curr.toString());
            return;
        }

        for (char j : map.get(digits.charAt(index)).toCharArray()) {
            curr.append(j);
            backtrack(digits, curr, index+1, res, map);
            curr.deleteCharAt(curr.length()-1);
        }



    }
}
