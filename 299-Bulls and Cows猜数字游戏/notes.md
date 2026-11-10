299. 猜数字游戏（Bulls and Cows）

## 题目

给定秘密数字 secret 和猜测数字 guess，返回提示 "xAyB"：

A（Bull）：数字和位置都正确。

B（Cow）：数字正确，但位置不正确。

注意：两个字符串都可能包含重复数字。

## 思路

哈希计数（频率统计）：使用两个计数数组 s[10] 和 g[10]，分别统计 secret 和 guess 中每个数字出现的次数。

遍历统计 A：遍历两个字符串，比较相同位置的字符，相同则 a++。

计算 A+B：遍历计数数组，使用 Math.min(s[i], g[i]) 计算每个数字最多能匹配的次数，累加得到 A+B。

计算 B：b = (A+B) - A。

## 复杂度

时间复杂度：(O(n))

空间复杂度：(O(1))，计数数组长度固定为 10。

## 其他解法

使用 ArrayList 的 contains() 和 remove() 进行匹配，需要注意重复数字和 Bull 的优先匹配问题，时间复杂度最坏为 (O(n^2))。

## 代码
```java
class Solution1 {
    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
		int a = 0, b = 0;
		int[] s = new int[10];
		int[] g = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			s[secret.charAt(i) - '0']++;
			g[guess.charAt(i) - '0']++;
			a += secret.charAt(i) == guess.charAt(i) ? 1 : 0;
		}
		for (int i = 0; i < s.length; i++) 
			b += Math.min(s[i], g[i]);
		return sb.append(a).append("A").append(b - a).append("B").toString();
    }
}

class Solution2 {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int n = secret.length();
        ArrayList<Character> nums = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            nums.add(secret.charAt(i));
        }

        for (int i = 0; i < n; ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
                nums.remove((Character) guess.charAt(i));
            }
        }

        for (int i = 0; i < n; ++i) {
            if (secret.charAt(i) != guess.charAt(i)
                    && nums.contains(guess.charAt(i))) {
                b++;
                nums.remove((Character) guess.charAt(i));
            }
        }

        return Integer.toString(a) + 'A' + Integer.toString(b) + 'B';
    }
}