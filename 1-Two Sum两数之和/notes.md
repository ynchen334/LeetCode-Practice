# 1. 两数之和

## 题目
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。

## 思路
目前使用暴力枚举：两层循环遍历所有组合，找到和为 target 的两个数

后续学完哈希表后，可以优化到 O(n)

## 要点
- 可以直接 `return new int[]{i, j}` 返回结果
- 注意 `j` 从 `i+1` 开始，避免使用同一个元素

## 复杂度
- 时间：O(n²)
- 空间：O(1)

## 代码
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i=0; i<n; ++i){
            for (int j=i+1; j<n; ++j){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}