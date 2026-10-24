# 2. 两数相加

## 题目
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.


## 思路
不是把两个链表的元素当成两个数相加，而是两两相加，因此短的链表可以理解为后面填充0

用dummy节点和尾节点构建新链表

将两个链表对应的元素两两相加，用carry表示进位

如果链表遍历结束后，有 carry>0，还需要在答案链表的后面附加一个节点，节点的值为carry


## 复杂度
- 时间：O(max(m,n))
- 空间：O(1)

## 代码
```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int total = val1 + val2 + carry;
            carry = total / 10;
            int val = total % 10;
            tail.next = new ListNode(val);
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;

    }
}