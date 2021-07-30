package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListInsertionSort {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(3);
    head.next.next = new ListNode(5);
    head.next.next.next = new ListNode(2);
    System.out.println(head);

    ListNode listNode = insertionSortList(head);
    System.out.println(listNode);

  }

  /**
   * 对链表进行插入排序
   * 147->https://leetcode-cn.com/problems/insertion-sort-list/
   *
   * @param head
   * @return
   */

  public static ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fakeNode = new ListNode(Integer.MIN_VALUE);
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      insertion(fakeNode, cur);
      cur = next;
    }
    return fakeNode.next;
  }

  public static void insertion(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return;
    }

    ListNode cur = l1;
    ListNode pre = l1;
    while (cur != null) {
      if (cur.val > l2.val) {
        pre.next = l2;
        l2.next = cur;
        break;
      }
      pre = cur;
      cur = cur.next;
    }
    if (pre.next == null) {
      pre.next = l2;
      l2.next = null;
    }
  }

  /**
   * 剑指 Offer 52. 两个链表的第一个公共节点
   * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
   *
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int length1 = 0;
    int length2 = 0;
    ListNode cur = headA;
    while (cur != null) {
      cur = cur.next;
      length1++;
    }
    cur = headB;
    while (cur != null) {
      cur = cur.next;
      length2++;
    }
    int diff = Math.abs(length1 - length2);
    ListNode more = length1 > length2 ? headA : headB;
    ListNode less = more == headA ? headB : headA;

    for (int i = 0; i < diff; i++) {
      more = more.next;
    }
    while (more != null && less != null) {
      if (more == less) {
        return less;
      }
      more = more.next;
      less = less.next;
    }
    return null;
  }

}
