class Solution2 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int left = 0;

        for (int right=0; right<n; ++right){
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}