#718. 最长重复子数组 
## 题目
给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。0 ，应忽略。nums2 的长度为 n 


## 代码
```java
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int curr1 = 0;
        int len = 0;

        while (curr1 < n1){
            int left = curr1;
            int currLen = 0;
            int right = 0;
            int curr2 = right;
            while (curr2 < n2 && left < n1){
                if (nums1[left] == nums2[curr2]){
                    currLen++;
                    curr2++;
                    left++;
                }else {
                    curr2 = ++right;
                    left = curr1;
                    len = Math.max(len, currLen);
                    currLen = 0;
                }
            }
            len = Math.max(len, currLen);
            curr1++;
        }
        return len;
    }
}