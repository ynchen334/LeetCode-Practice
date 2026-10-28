class Solution1 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        int profit;
        int n = prices.length;

        for (int i=0; i<n-1; ++i){
            buy = prices[i];
            for (int j=i; j<n; ++j){
                sell = prices[j];
                profit = sell - buy;
                if (profit > maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }
}