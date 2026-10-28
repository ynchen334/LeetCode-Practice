# 121.买卖股票的最佳时机
## 题目
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

## 思路
- 解法一：嵌套循环，超时
- 解法二：遍历一次数组，比较并更新最小的值作为买入值，同时将此时的利润与之前的比较并更新

## 要点
注意设置变量时将buy设为最大，利润设为零

## 代码
```java
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