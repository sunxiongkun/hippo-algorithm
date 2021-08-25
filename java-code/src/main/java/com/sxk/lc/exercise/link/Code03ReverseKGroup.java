package com.sxk.lc.exercise.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class Code03ReverseKGroup {

  public static void main(String[] args) {

    ListNode listNode = ListNode.sequenceList(1, 5);
    System.out.println(listNode);
    // System.out.println(reverse(listNode));

  }

  /**
   * K 个一组翻转链表
   * 25 -> https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
   *
   * @param head
   * @param k
   * @return
   */
  public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode fakeNode = new ListNode();
    fakeNode.next = head;
    ListNode pre = fakeNode;
    ListNode end = fakeNode;
    while (end.next != null) {
      for (int i = 0; i < k && end.next != null; i++) {
        end = end.next;
      }
      if (end.next == null) {
        break;
      }
      ListNode start = pre.next;
      ListNode next = end.next;
      end.next = null;
      pre.next = reverse(start);
      start.next = next;
      pre = start;
      end = start;
    }
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
