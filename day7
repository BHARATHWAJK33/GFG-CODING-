class Solution {
    public int maximumProfit(int prices[]) {
        // code here 
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If selling today gives profit, sell
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
    
}
