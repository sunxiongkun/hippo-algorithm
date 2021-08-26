package com.sxk.lc.exercise.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class Code16LinkMerge {

  public static void main(String[] args) {

  }

  /**
   * 23. 合并K个升序链表
   * https://leetcode-cn.com/problems/merge-k-sorted-lists/
   *
   * @param lists
   * @return
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    return mergeKLists(lists, 0, lists.length - 1);
  }

  public ListNode mergeKLists(ListNode[] lists, int left, int right) {
    if (left == right) {
      return lists[left];
    }
    if (left > right) {
      return null;
    }
    int middle = left + (right - left) / 2;
    ListNode headA = mergeKLists(lists, left, middle);
    ListNode headB = mergeKLists(lists, middle + 1, right);
    return mergeTwoLists(headA, headB);
  }


  public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return headA == null ? headB : headA;
    }
    ListNode fakeNode = new ListNode();
    ListNode cur = fakeNode;
    ListNode p1 = headA;
    ListNode p2 = headB;
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
