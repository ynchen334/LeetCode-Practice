class Solution {
    public boolean isPalindrome(int x) {
    
        
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int revNumber = 0;
        while(x > revNumber){
            revNumber = revNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revNumber || x == revNumber / 10;
    }
}