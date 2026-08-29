class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // freq = <number, frequency>
        Map<Integer, Integer> freq = new HashMap<>();

        // entry in heap = <frequency, number>, ordered by frequency
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = heap.poll()[1];
        }
        return topk;
    }
}
