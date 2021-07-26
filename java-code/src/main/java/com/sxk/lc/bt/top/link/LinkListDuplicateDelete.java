package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListDuplicateDelete {

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(3);
    head.next.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next.next.next = new ListNode(4);

    System.out.println(head);
    System.out.println(deleteDuplicates(head));
  }

  /**
   * 删除链表(升序链表)中重复元素
   * 82-> https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
   *
   * @param head
   * @return
   */

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode fakeNode = new ListNode(0);
    fakeNode.next = head;
    ListNode cur = fakeNode;
    while (cur.next != null && cur.next.next != null) {
      if (cur.next.val == cur.next.next.val) {
        int x = cur.next.val;
        while (cur.next != null && cur.next.val == x) {
          cur.next = cur.next.next;
        }
      } else {
        cur = cur.next;
      }
    }

    return fakeNode.next;
  }

  /**
   * 删除链表(升序链表)中重复元素
   * 83-> https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
   *
   * @param head
   * @return
   */
  public static ListNode deleteDuplicates2(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }


}
