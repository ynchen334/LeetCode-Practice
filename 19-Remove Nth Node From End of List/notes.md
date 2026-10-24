# 19. 移除倒数第n个元素

## 题目
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

## 思路
快慢指针：先用fast走n次，再让fast和slow同时走，这样就可以找到倒数第n个节点

## 要点


## 代码
```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode (0, head);
        ListNode fast = new ListNode (0, head);
        ListNode slow = dummy;
        
        for (int i=0; i<n; ++i){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}