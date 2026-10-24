# 14. 最长公共元素

## 题目
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

## 思路
解法一：一个一个试，不好

解法二：先定义一个方法，找出两个字符串的最长公共前缀
       对数组中每个字符串和后头的字符串用这个方法，找出最长公共前缀 
## 要点
- 可以额外定义方法
- Math.min(a, b) 调用最小值方法
- s.substring(a, b) 子字符串，从s[a]开始，不包含s[b]

## 代码
```java
class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int currChar = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        while (flag == true){
            for (int j=0; j<n-1; ++j){
                if ( currChar >=strs[j].length() || currChar >= strs[j+1].length() || strs[j].charAt(currChar) != strs[j+1].charAt(currChar) ){
                    flag = false;
                    break;
                }
            }
            if (flag == true){
                sb.append(strs[0].charAt(currChar));
                currChar++;
            }
        }
        return sb.toString();
    }
}

class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        
        if (strs.length == 0 || strs == null){
            return "";
        }
        for (int i=0; i<strs.length; ++i){
            prefix = longestCommonPrefix(strs[i], prefix);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }
    public String longestCommonPrefix(String a, String b){
        int len = Math.min(a.length(), b.length());
        int index = 0;
        while (index < len && a.charAt(index) == b.charAt(index)){
            index++;
        }
        return a.substring(0, index);
    }
}