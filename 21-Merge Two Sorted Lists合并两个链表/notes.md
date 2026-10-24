# 21. 合并两个链表
## 题目
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的

## 思路
用curr.next来接住最大的那个节点

## 要点
错误代码：
while(l1.next != null || l2.next != null ){
            if (l1.val < l2.val){
                l1.next = l2;
                l1 = l1.next;
            }else if (l1.val > l2.val){
                l2.next = l1;
                l2 = l2.next;
            }else{
                l2.next = l1;
                l2 = l2.next;
                l1 = l1.next;
            }
        }
这样写会陷入死循环

## 代码
```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
       
        while(list1 != null && list2 != null ){
            if (list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (list1 == null) ? list2 : list1;

        return dummy.next;
    }
}