package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListMerge {

  public static void main(String[] args) {

    ListNode head1 = ListNode.sequenceList(2, 4);
    ListNode head2 = ListNode.sequenceList(4, 8);
    System.out.println(mergeTwoList(head1, head2));

  }

  /***
   * https://leetcode-cn.com/problems/merge-k-sorted-lists/
   * 给你一个链表数组，每个链表都已经按升序排列。
   * @param lists
   * @return
   */
  public static ListNode mergeKLists2(ListNode[] lists) {
    int length = lists.length;
    if (length == 0) {
      return null;
    }
    if (length == 1) {
      return lists[0];
    }
    ListNode cur = lists[0];
    for (int i = 1; i < length; i++) {
      ListNode next = lists[i];
      cur = mergeTwoList(cur, next);
    }
    return cur;
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    int length = lists.length;
    if (length == 0) {
      return null;
    }
    return mergeKLists(lists, 0, length - 1);
  }

  public static ListNode mergeKLists(ListNode[] lists, int l, int r) {
    if (l == r) {
      return lists[l];
    }
    if (l > r) {
      return null;
    }
    int mid = l + (r - l) / 2;
    return mergeTwoList(mergeKLists(lists, l, mid), mergeKLists(lists, mid + 1, r));
  }

  public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
    if (head1 == null || head2 == null) {
      return head1 != null ? head1 : head2;
    }
    ListNode fakeNode = new ListNode();
    ListNode cur = fakeNode;
    while (head1 != null && head2 != null) {
      if (head1.val < head2.val) {
        cur.next = head1;
        head1 = head1.next;
      } else {
        cur.next = head2;
        head2 = head2.next;
      }
      cur = cur.next;
    }
    if (head1 != null) {
      cur.next = head1;
    }
    if (head2 != null) {
      cur.next = head2;
    }
    return fakeNode.next;
  }

}
