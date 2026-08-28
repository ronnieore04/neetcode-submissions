class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26];
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> entry = new LinkedList<>();
                entry.add(str);
                map.put(key, entry);
            }
        }

        return new LinkedList<>(map.values());
    }
}
