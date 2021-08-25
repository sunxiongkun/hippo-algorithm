package com.sxk.lc.exercise.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class Code12LinkReOrder {

  public static void main(String[] args) {

  }

  /**
   * 143. 重排链表
   * https://leetcode-cn.com/problems/reorder-list/
   *
   * @param head
   */
  public static void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode middle = findMiddle(head);

    ListNode middleNext = middle.next;

    middle.next = null;

    ListNode secondHead = reverse(middleNext);

    mergeTwoList(head, secondHead);
  }

  public static ListNode findMiddle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode slowNode = head.next;
    ListNode fastNode = head.next.next;
    while (fastNode.next != null && fastNode.next.next != null) {
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    return slowNode;
  }


  public static ListNode reverse(ListNode head) {
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


  public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) {
      return head1 == null ? head2 : head1;
    }
    ListNode fakeNode = new ListNode();
    ListNode p1 = head1;
    ListNode p2 = head2;
    ListNode cur = fakeNode;
    int i = 0;
    while (p1 != null && p2 != null) {
      if (i++ % 2 == 0) {
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
