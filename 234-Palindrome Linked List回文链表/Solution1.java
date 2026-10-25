/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution1 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;

        ListNode newHead = reverseList(slow);
        while(newHead != null){
            if (head.val == newHead.val){
                head = head.next;
                newHead = newHead.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
        return head;
    }
        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}