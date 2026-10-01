class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[]{nums[i], i}); // {value, index}
            if (i >= k - 1) { // window size reached, k-1 because 0-based index

                // clear out old maximums if index outdated
                while (heap.peek()[1] <= i - k) {
                    heap.poll();
                }
                // update output
                res[index++] = heap.peek()[0];
            }
        }
        return res;
    }
}
