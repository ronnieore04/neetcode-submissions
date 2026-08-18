class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2]; // [position, speed]
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0])); // descending order
        Stack<Double> fleets = new Stack<>();

        for (int i = 0; i < pairs.length; i++) {
            double arrival_time = ((double)(target - pairs[i][0]))/((double)(pairs[i][1]));
            if (fleets.isEmpty()) {
                fleets.push(arrival_time);
            } else if (arrival_time > fleets.peek()) {
                fleets.push(arrival_time);
            }
        }
        return fleets.size();
    }
}
