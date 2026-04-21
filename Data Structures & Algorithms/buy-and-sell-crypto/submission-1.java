class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];
        int profit = 0;

        for(int i=1;i<prices.length;i++){
            lowest = Math.min(lowest, prices[i]);

            profit = Math.max(profit, prices[i] - lowest);
        }

        return profit;
    }
}
