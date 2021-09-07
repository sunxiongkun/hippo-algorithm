package com.sxk.lc.exercise.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class Code37LinkDeleteDuplicate {


  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(3);
    System.out.println(head);

    System.out.println(deleteDuplicates(head));

  }

  /**
   * 82. 删除排序链表中的重复元素 II
   * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
   * 按升序排列的链表删除重复元素
   *
   * @param head
   * @return
   */
  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode fakeNode = new ListNode();
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

}
