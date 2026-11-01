# 231. 2的幂

## 题目
给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。

如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。

## 思路
- 位运算判断是否只有最高位是1
- 递归判断是否有余数为一（非零）

## 要点


## 代码
```java
class Solution1 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

class Solution2 {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 2 == 1) return false;
        return isPowerOfTwo(n / 2); 
    }
}