package com.sxk.lc.top100;

import com.sxk.entity.ListNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import lombok.Data;

/**
 * @author sxk
 */
public class LinkTest {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int num = 0;
    ListNode node1 = l1;
    ListNode node2 = l2;
    final ListNode fakeNode = new ListNode();
    ListNode cur = fakeNode;
    while (node1 != null || node2 != null) {
      int x = (node1 != null) ? node1.val : 0;
      int y = (node2 != null) ? node2.val : 0;
      int sumVal = x + y + num;
      if (sumVal < 10) {
        num = 0;
      } else {
        num = 1;
      }
      final int curVal = sumVal % 10;
      cur.next = new ListNode(curVal);
      cur = cur.next;
      if (node1 != null) {
        node1 = node1.next;
      }
      if (node2 != null) {
        node2 = node2.next;
      }
    }
    if (num > 0) {
      cur.next = new ListNode(num);
    }
    return fakeNode.next;
  }

  /**
   * 1< n < size
   *
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    final ListNode fakeNode = new ListNode();
    fakeNode.next = head;
    ListNode fastNode = fakeNode;
    ListNode slowNode = fakeNode;
    for (int i = 0; i <= n; i++) {
      fastNode = fastNode.next;
    }
    while (fastNode != null) {
      fastNode = fastNode.next;
      slowNode = slowNode.next;
    }
    slowNode.next = slowNode.next.next;
    return fakeNode.next;
  }


  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return l1 != null ? l1 : l2;
    }
    final ListNode fakeNode = new ListNode();
    ListNode cur = fakeNode;
    ListNode p1 = l1;
    ListNode p2 = l2;
    while (p1 != null && p2 != null) {
      if (p1.val < p2.val) {
        cur.next = p1;
        cur = cur.next;
        p1 = p1.next;
      } else {
        cur.next = p2;
        cur = cur.next;
        p2 = p2.next;
      }
    }
    cur.next = p1 != null ? p1 : p2;
    return fakeNode.next;
  }

  public ListNode mergeKLists(ListNode[] lists) {
    return merge(lists, 0, lists.length - 1);
  }

  public ListNode merge(ListNode[] lists, int l, int r) {
    if (l == r) {
      return lists[l];
    }
    if (l > r) {
      return null;
    }
    int mid = l + (r - l) / 2;
    return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
  }

  @Data
  private static class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>(16);
    Node cur = head;
    while (cur != null) {
      map.put(cur, new Node(cur.val));
      cur = cur.next;
    }
    cur = head;
    while (cur != null) {
      map.get(cur).next = map.get(cur.next);
      map.get(cur).random = map.get(cur.random);
      cur = cur.next;
    }
    return map.get(head);
  }

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return false;
    }
    ListNode fastNode = head.next.next;
    ListNode slowNode = head.next;
    while (fastNode != slowNode) {
      if (fastNode.next == null || fastNode.next.next == null) {
        return false;
      }
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    return true;
  }

  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  /**
   * 假设没有环
   *
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode cur1 = headA;
    ListNode cur2 = headB;
    int n = 0;
    while (cur1.next != null) {
      n++;
      cur1 = cur1.next;
    }
    while (cur2.next != null) {
      n--;
      cur2 = cur2.next;
    }
    if (cur1 != cur2) {
      return null;
    }
    //链表1长度减去链表2长度的值
    cur1 = n > 0 ? headA : headB;
    cur2 = cur1 == headA ? headB : headA;
    n = Math.abs(n);
    while (n != 0) {
      n--;
      cur1 = cur1.next;
    }
    while (cur1 != cur2) {
      cur1 = cur1.next;
      cur2 = cur2.next;
    }
    return cur1;
  }

  public static Node getLoopNode(Node head) {
    if (head == null || head.next == null || head.next.next == null) {
      return null;
    }
    // n1 慢  n2 快
    Node slow = head.next; // n1 -> slow
    Node fast = head.next.next; // n2 -> fast
    while (slow != fast) {
      if (fast.next == null || fast.next.next == null) {
        return null;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    // slow fast  相遇
    fast = head; // n2 -> walk again from head
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  /**
   * O(N) O(1)
   *
   * @param head
   * @return
   */
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode fastNode = head;
    ListNode slowNode = head.next;
    while (fastNode.next != null && fastNode.next.next != null) {
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    Stack<ListNode> stack = new Stack<>();
    while (slowNode != null) {
      stack.push(slowNode);
      slowNode = slowNode.next;
    }
    while (!stack.isEmpty()) {
      if (head.val != stack.pop().val) {
        return false;
      }
      head = head.next;
    }
    return true;
  }

  public void deleteNode(ListNode node) {
    if (node == null) {
      return;
    }
    node.val = node.next.val;
    node.next = node.next.next;
  }

  public static ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode evenHead = head.next;
    ListNode odd = head, even = evenHead;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }

  public ListNode sortList(ListNode head) {
    return sortList(head, null);
  }

  public ListNode sortList(ListNode head, ListNode tail) {
    if (head == null) {
      return null;
    }
    //断开
    if (head.next == tail) {
      head.next = null;
      return head;
    }
    ListNode slow = head, fast = head;
    while (fast != tail) {
      slow = slow.next;
      fast = fast.next;
      if (fast != tail) {
        fast = fast.next;
      }
    }
    ListNode mid = slow;
    ListNode list1 = sortList(head, mid);
    ListNode list2 = sortList(mid, tail);
    return mergeTwoLists(list1, list2);
  }


  public static void main(String[] args) {
    final ListNode head = ListNode.sequenceList(5);
    System.out.println(head);
    final ListNode head1 = oddEvenList(head);
    System.out.println(head1);
    System.out.println(head);
  }

}
