import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        ListNode curr = head;
        while (curr != null){
            vals.add(curr.val);
            curr = curr.next;
        }

        int left = 0;
        int right = vals.size()-1;
        while (left < right){
            if (!vals.get(left).equals(vals.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
