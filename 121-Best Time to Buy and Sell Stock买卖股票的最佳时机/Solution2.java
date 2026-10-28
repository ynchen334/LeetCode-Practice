class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int buy = Integer.MAX_VALUE; 
        int profit = 0;

        for (int price : prices){
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }
}