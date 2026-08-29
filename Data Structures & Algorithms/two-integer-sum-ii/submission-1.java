class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i+1);
            } else {
                ret[0] = map.get(target - numbers[i]);
                ret[1] = i+1;
            }
        }
        return ret;
    }
}
