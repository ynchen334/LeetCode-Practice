# 88. 合并有序数组
## 题目
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

## 思路
- 逆向双指针：两个数组分别在尾部设置一个指针，设第三个指针指向nums1尾部，判断连个指针指向元素大小，大的赋给nums[i--]，同时指针减1
- 合并两个数组后再排序

## 代码
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        while (n > 0){
            if (m > 0 && nums1[m - 1] > nums2[n - 1]){
                nums1[i--] = nums1[m - 1];
                m--;
            }else {
                nums1[i--] = nums2[n - 1];
                n--;
            }
        }
    }
}