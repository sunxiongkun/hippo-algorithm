package com.sxk.lc.exercise.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class Code31LinkSort {


  public static void main(String[] args) {

    Code31LinkSort test = new Code31LinkSort();

    ListNode listNode = ListNode.sequenceList(1, 7);

    System.out.println(test.sortList(listNode));
  }

  /**
   * 148. 排序链表
   * https://leetcode-cn.com/problems/sort-list/
   *
   * @param head
   * @return
   */
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
    return mergeList(list1, list2);
  }


  public ListNode mergeList(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) {
      return head1 == null ? head2 : head1;
    }
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

  public ListNode findMiddle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode fastNode = head.next.next;
    ListNode slowNode = head.next;
    while (fastNode.next != null && fastNode.next.next != null) {
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    return slowNode;
  }
}
