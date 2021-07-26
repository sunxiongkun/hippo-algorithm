package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListPartition {

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(3);
    head.next.next = new ListNode(5);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(2);

    System.out.println(partition(head, 2));


  }

  /**
   * 分割链表
   * 86 -> https://leetcode-cn.com/problems/partition-list/
   *
   * @param head
   * @param x
   * @return
   */
  public static ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fakeNode = new ListNode();
    ListNode p1 = fakeNode;

    ListNode fakeNode2 = new ListNode();
    ListNode p2 = fakeNode2;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val < x) {
        p1.next = cur;
        p1 = p1.next;
      } else {
        p2.next = cur;
        p2 = p2.next;
      }
      cur = cur.next;
    }
    p2.next = null;
    p1.next = fakeNode2.next;

    return fakeNode.next;
  }
}
