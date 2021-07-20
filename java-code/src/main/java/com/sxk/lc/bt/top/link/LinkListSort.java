package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListSort {

  public static void main(String[] args) {

    ListNode head = ListNode.sequenceList(1, 6);

    System.out.println(head);
    System.out.println(sortList(head));
  }

  /**
   * 排序链表
   * 148 -> https://leetcode-cn.com/problems/sort-list/
   *
   * @param head
   * @return
   */
  public static ListNode sortList(ListNode head) {
    return sortList(head, null);
  }

  public static ListNode sortList(ListNode head, ListNode tail) {
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
    return mergeTowList(list1, list2);
  }

  public static ListNode findMiddle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode slow = head.next;
    ListNode fast = head.next.next;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public static ListNode mergeTowList(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) {
      return head1 != null ? head1 : head2;
    }
    ListNode fakeNode = new ListNode();
    ListNode cur = fakeNode;
    ListNode l1 = head1;
    ListNode l2 = head2;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if (l1 != null) {
      cur.next = l1;
    }
    if (l2 != null) {
      cur.next = l2;
    }
    return fakeNode.next;
  }


}
