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
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {  
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head == null) return null;

        ListNode fast = head.next;
        ListNode slow = head;
        ListNode newHead = head;

        while (fast != null){
            if (fast.val == val){
                slow.next = fast.next;
                fast.next = null;
                fast = slow.next;
            }else{
                fast = fast.next;
                slow = slow.next;
            }
        }
        return head;
    }
}