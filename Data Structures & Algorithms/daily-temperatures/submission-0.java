class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        // each int[] holds the curr temp 
        for(int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                // popping conditions
                int[] day = stack.pop();
                output[day[1]] = i - day[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return output;
    }
}
