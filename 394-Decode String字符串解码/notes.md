# 394. 字符串解码
## 题目
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例 1：

输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：

输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：

输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
示例 4：

输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"

## 思路
数字存放在数字栈，字符串存放在字符串栈，遇到右括号时候弹出一个数字栈，字母栈弹到左括号为止

## 要点
注意在遇到正括号时将重复数和字符串重置

## 代码
```java
class Solution {
    public String decodeString(String s) {
        if (s.length() == 0) return null;
        Deque<Integer> nums = new ArrayDeque<>(); 
        Deque<String> strings = new ArrayDeque<>(); 
        String currentString = "";
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                strings.push(currentString);
                nums.push(k);
                currentString = "";
                k = 0;
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(strings.pop());
                int n = nums.pop();
                temp.append(currentString.repeat(n));
                currentString = temp.toString();
            } else {
                currentString += c;
            }
        }
        return currentString;
    }
}