class Solution1 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        
        if (x < 0) return false;

        int left = 0;
        int right = s.length() - 1;        

        while(left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}