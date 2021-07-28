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

    head1 = ListNode.sequenceList(0, 6);
    head2 = ListNode.sequenceList(100, 110);
    System.out.println(mergeInBetween(head1, 3, 4, head2));

  }

  /**
   * 合并k个有序链表
   * 23 -> https://leetcode-cn.com/problems/merge-k-sorted-lists/
   * 给你一个链表数组，每个链表都已经按升序排列。
   *
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

  /**
   * 合并两个有序链表
   * 21 -> https://leetcode-cn.com/problems/merge-two-sorted-lists/
   *
   * @param head1
   * @param head2
   * @return
   */
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


  /**
   * 合并两个链表
   * 1669->https://leetcode-cn.com/problems/merge-in-between-linked-lists/
   * <p>
   * 3 <= list1.length <= 104
   * 1 <= a <= b < list1.length - 1
   * 1 <= list2.length <= 104
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param list1
   * @param a
   * @param b
   * @param list2
   * @return
   */
  public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode fakeNode = new ListNode();
    fakeNode.next = list1;
    ListNode cur = fakeNode;

    int i;
    //走到第a的前一个节点
    for (i = 0; i < a; i++) {
      cur = cur.next;
    }
    ListNode firstPreNode = cur;
    //走到第b个节点
    for (; i <= b + 1; i++) {
      cur = cur.next;
    }
    ListNode secondNextNode = cur;
    firstPreNode.next = list2;

    ListNode temp = list2;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = secondNextNode;

    return fakeNode.next;
  }

}
