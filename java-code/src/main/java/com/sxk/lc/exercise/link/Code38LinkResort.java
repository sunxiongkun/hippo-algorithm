package com.sxk.lc.exercise.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class Code38LinkResort {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(8);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(6);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(4);

    System.out.println(head);

    System.out.println(reorderList(head));
  }

  /**
   * 排序奇升偶降链表
   * https://mp.weixin.qq.com/s/0WVa2wIAeG0nYnVndZiEXQ
   * <p>
   * 输入: 1->8->3->6->5->4->7->2->NULL
   * 输出: 1->2->3->4->5->6->7->8->NULL
   *
   * @param head
   * @return
   */
  public static ListNode reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fakeNode1 = new ListNode();
    ListNode fakeNode2 = new ListNode();

    ListNode cur1 = fakeNode1;
    ListNode cur2 = fakeNode2;
    ListNode cur = head;
    int i = 0;
    while (cur != null) {
      if (i++ % 2 == 0) {
        cur1.next = cur;
        cur1 = cur1.next;
      } else {
        cur2.next = cur;
        cur2 = cur2.next;
      }
      cur = cur.next;
    }
    cur1.next = null;
    cur2.next = null;
    ListNode reverse = reverse(fakeNode2.next);
    return merge(fakeNode1.next, reverse);
  }

  public static ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    return pre;
  }

  public static ListNode merge(ListNode head1, ListNode head2) {
    ListNode fakeNode = new ListNode();
    ListNode cur = fakeNode;
    ListNode p1 = head1;
    ListNode p2 = head2;
    while (p1 != null && p2 != null) {
      if (p1.val < p2.val) {
        cur.next = p1;
        p1 = p1.next;
      } else {
        cur.next = p2;
        p2 = p2.next;
      }
      cur = cur.next;
    }
    if (p1 != null) {
      cur.next = p1;
    }
    if (p2 != null) {
      cur.next = p2;
    }
    return fakeNode.next;
  }

}
