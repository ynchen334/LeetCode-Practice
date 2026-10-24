# 9. 回文数

## 题目
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数

## 思路
解法一：用双指针比较两端的数字是否相等

解法二（耗时短）：将x的后半部分倒过来为revNumber，比较x和revNumber
并且由于回文数对称，只需要倒置一半

## 要点
- s.charAt(index) 用来表示字符串的特定字符
- 用 return x == revNumber || x == revNumber / 10 解决x位数为奇数的情况
- 可以先排除一些极端情况

## 代码
```java
class Solution1 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        
        if (x < 0) return false;

        int left = 0;
        int right = s.length() - 1;        

        while(left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}

class Solution {
    public boolean isPalindrome(int x) {
    
        
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int revNumber = 0;
        while(x > revNumber){
            revNumber = revNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revNumber || x == revNumber / 10;
    }
}