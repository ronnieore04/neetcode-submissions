class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minRate = 1;
        int maxRate = Arrays.stream(piles).max().getAsInt();
        int res = 1;
        while (minRate <= maxRate) {
            int avgRate = (minRate + maxRate)/2;
            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / avgRate);
            }
            if (totalTime > h) {
                minRate = avgRate + 1;
            } else {
                res = avgRate;
                maxRate = avgRate - 1;
            }

        }
        return res;
    }
}
