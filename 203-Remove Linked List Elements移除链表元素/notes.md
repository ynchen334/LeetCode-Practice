# 203. 移除链表元素
## 题目
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

## 思路
- 递归，从后往前进行判定
- 快慢指针，注意先移动head（同时条件要加head不为空），再返回head为空的情况

## 代码
```java
class Solution1 {
    public ListNode removeElements(ListNode head, int val) {  
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}

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