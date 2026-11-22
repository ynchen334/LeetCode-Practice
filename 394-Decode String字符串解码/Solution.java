import java.util.Deque;
import java.util.ArrayDeque;

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