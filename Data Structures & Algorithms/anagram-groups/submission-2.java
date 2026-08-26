class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // <frequency counts arr[], strings>
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int[] counts = new int[26];
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                counts[str.charAt(j) - 'a']++;
            }

            String key = Arrays.toString(counts);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> boop = new LinkedList<>();
                boop.add(str);
                map.put(key, boop);
            }
        }

        return new LinkedList<>(map.values());
    }
}
