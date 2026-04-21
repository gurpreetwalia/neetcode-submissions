class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int minSoFar = prices[0];
        int maxSoFar = 0;

        for(int price : prices){
            minSoFar = Math.min(minSoFar, price);
            maxSoFar = Math.max(maxSoFar, price - minSoFar);
        }

        return maxSoFar;
    }
}
