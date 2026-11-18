# 739. 每日温度
## 题目
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。

## 思路
单调栈：用 Deque 实现单调栈，对数组进行遍历，如果遍历到的元素大于栈顶元素代表的数组元素，就弹出栈顶元素 index ，让返回数组的index位置等于 i-index ，即当前索引和index的距离

可以理解为，把暂时无法判断的元素都存起来，所以站内应该存入索引而不是元素本身

## 要点
- 先判断再push
- 通过 while 循环来实现完全的判断
- 优先用deque而不是stack，stack占用资源多，安全性差
- 单调栈内元素始终保持单调递增或单调递减的顺序

## 时间复杂度
O(n)

## 代码
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i<temperatures.length; ++i){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }   
        return res;     
    }
}