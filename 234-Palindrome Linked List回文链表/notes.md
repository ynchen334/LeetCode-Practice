# 21. 回文链表
## 题目
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

## 思路
- 思路一:  先用快慢指针找到中间的节点，然后用反转链表，比较两个新列表
        用递归的方法反转列表
        递归反转链表的本质：递归负责把后面的节点反转好，当前层负责把自己接到反转后的链表末尾
        耗时较长

## 要点
- 找中间节点时，注意要判断节点总数实际还是偶，是奇数的话要让slow往后跳一个

## 代码
```java
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

        head.next.next = head;     //head.next.next = head：让后一个节点指回当前节点
        head.next = null;          //断开原来的连接，防止形成环

        return newHead;
    }
}