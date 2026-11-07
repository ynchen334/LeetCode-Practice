# 143. 重排链表
## 题目
给定一个单链表 L 的头节点 head ，单链表 L 表示为：

L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

## 思路
题目可以理解为反转链表后半段，然后前半段与后半段一个一个合并（head在前）
构造找到链表中点，反转链表，合并链表三个函数

## 要点
- 找到middle后要让后半部分链表的头等于middle.next，然后让middle.next为空，这样来断开两个链表，防止形成回环
- 合并链表时注意临时节点的声明

## 复杂度分析
时间复杂度：O(N)，其中 N 是链表中的节点数

空间复杂度：O(1)

## 代码
```java
class Solution {
    public void reorderList(ListNode head) {
        if (head ==  null) return;

        ListNode middle = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = middle.next;
        middle.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2){
        while (l1 != null && l2 != null){
            ListNode l1_tmp = l1.next;
            ListNode l2_tmp = l2.next;
            
            l1.next = l2;
            l1 = l1_tmp;
            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}