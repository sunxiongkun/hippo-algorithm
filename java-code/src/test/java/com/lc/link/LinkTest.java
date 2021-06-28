package com.lc.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 * @date 2021/5/7 8:55 下午
 */
public class LinkTest {

  public static void main(String[] args) {
    final ListNode head = ListNode.sequenceList(4);
    System.out.println(head);
    System.out.println(firstSecond(head));

    System.out.println(reverse(head));

  }

  public static Integer firstSecond(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow.val;
  }

  public static ListNode reverse(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    return pre;
  }

}
