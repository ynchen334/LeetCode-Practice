20. 有效的括号

## 题目

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号

## 思路

用栈存所有正括号，遇见反括号进行匹配


## 代码
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()) return false;
                if (s.charAt(i) == ')' && stack.peek() != '(') return false;
                if (s.charAt(i) == '}' && stack.peek() != '{') return false;
                if (s.charAt(i) == ']' && stack.peek() != '[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}