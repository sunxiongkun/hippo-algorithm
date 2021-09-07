package com.sxk.lc.exercise.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class Code21LinkReverse {


  public static void main(String[] args) {
    ListNode head = ListNode.sequenceList(1, 7);
    System.out.println(head);
    ListNode newHead = reverseBetween(head, 3, 5);
    System.out.println(newHead);
  }

  /**
   * 92. 反转链表 II
   * https://leetcode-cn.com/problems/reverse-linked-list-ii/
   *
   * @param head
   * @param left
   * @param right
   * @return
   */
  public static ListNode reverseBetween(ListNode head, int left, int right) {

    ListNode fakeNode = new ListNode();
    fakeNode.next = head;
    ListNode cur = fakeNode;

    int i = 1;
    for (; i < left; i++) {
      cur = cur.next;
    }
    ListNode startPre = cur;
    ListNode start = startPre.next;

    for (; i <= right; i++) {
      cur = cur.next;
    }
    ListNode end = cur;

    ListNode secondNext = end.next;
    end.next = null;

    startPre.next = reverse(start);
    start.next = secondNext;

    return fakeNode.next;
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
}
