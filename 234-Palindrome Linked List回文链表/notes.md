# 21. 回文链表
## 题目
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

## 思路
- 思路一:先用快慢指针找到中间的节点，然后用反转链表，比较两个新列表
        用递归的方法反转列表
        递归反转链表的本质：递归负责把后面的节点反转好，当前层负责把自己接到反转后的链表末尾
        耗时较长
- 思路二：创建一个ArrayList类数组，把链表的每一个元素保存进数组，然后用双指针比较数组是否回文

## 要点
- 找中间节点时，注意要判断节点总数实际还是偶，是奇数的话要让slow往后跳一个
- ArrayList是java类，可理解为一个长度可以自动变化的数组
  ArrayList<Integer> list = new ArrayList<>();
  常用方法： add(e)	         在末尾添加元素
            add(e)	        在末尾添加元素	    list.add(40)
            add(index, e)	在指定位置插入元素	 list.add(1, 15)
            get(index)	    获取元素	        list.get(0)
            set(index, e)	替换指定位置的元素	 list.set(0, 99)
            remove(index)	删除指定下标的元素	 list.remove(0)
            remove(Object)	删除匹配的元素	     list.remove(Integer.valueOf(20))
            size()	        获取元素个数	     list.size()
            isEmpty()	    判断集合是否为空	 list.isEmpty()
            contains(e)	    判断是否包含某元素	 list.contains(20)
            clear()	        清空集合
            sort()          升序
 访问，替换，删除末尾元素的时间复杂度O(1), 中间插入，删除，判断是否存在为O(n)
 判断两个 ArrayList 的元素是否相等，通常使用 equals()


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
