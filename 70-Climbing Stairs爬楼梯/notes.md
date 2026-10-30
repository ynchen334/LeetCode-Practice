# 70.爬楼梯
## 题目
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

## 思路
可以理解为斐波那契数列，到第n个台阶的方法数就是到n-1和n-2个台阶方法数的和
- 递归法（超时）
- 迭代（动态规划/滚动数组）用a，b代表n-1和n-2，让他们滚动相加

## 要点
注意直接写a = b; b += a; 会导致数据覆盖，需要用第三个变量临时存储

## 代码
```java
class Solution1 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n-1) + climbStairs(n-2);
    }
}

class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int a = 1;
        int b = 2;

        for (int i=3; i<=n; ++i){
            int temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }
}