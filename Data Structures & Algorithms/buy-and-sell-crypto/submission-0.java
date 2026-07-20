class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) { return 0; } // edge case

        int[] buys = new int[prices.length];
        int[] sells = new int[prices.length];

        int min = prices[0];
        for (int i=1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            buys[i] = min;
        }

        int diff = 0;
        for (int i=1; i < prices.length; i++) {
            diff = Math.max(diff, prices[i]-buys[i]);
        }
        return diff;
    }
}

// prefix: 10 1 1 1 1 1
// suffix: 10 7 7 7 7 1