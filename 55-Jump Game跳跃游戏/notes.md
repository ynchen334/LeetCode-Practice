# 55. 跳跃游戏
## 题目
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。

## 思路
遍历数组，比较并每个点，保存能往后跳到的最大位置，如果超过或等于界限则判断true

## 要点
注意每次判断的前提条件是max大于当前索引
例如 [3,2,1,0,4]，索引为 4 时max为 3 ，因为一定会跳到 0 元素

## 代码
```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;

        for (int i=0; i<n; ++i) {
            if (max >= i){
                max = Math.max(max, i + nums[i]);
                if (max >= n-1) return true;
            }
        }
        return false;
    }
}