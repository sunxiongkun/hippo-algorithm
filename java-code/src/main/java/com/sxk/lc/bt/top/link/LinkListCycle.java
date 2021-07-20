package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListCycle {

  public static void main(String[] args) {
    ListNode listNode = ListNode.sequenceList(6);
    System.out.println(listNode);

    System.out.println(hasCycle(listNode));
    System.out.println(detectCycle(listNode));

    ListNode tail = listNode.getTail();
    tail.next = listNode.next.next;

    System.out.println(hasCycle(listNode));
    System.out.println(detectCycle(listNode).val);

  }

  /**
   * 环形链表
   * 141 -> https://leetcode-cn.com/problems/linked-list-cycle/
   *
   * @param head
   * @return
   */
  public static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return false;
    }
    ListNode slowNode = head.next;
    ListNode fastNode = head.next.next;
    while (fastNode != slowNode) {
      if (fastNode.next == null || fastNode.next.next == null) {
        return false;
      }
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    return true;
  }

  /**
   * 环形链表ii
   * 142 -> https://leetcode-cn.com/problems/linked-list-cycle-ii/
   *
   * @param head
   * @return
   */
  public static ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return null;
    }
    ListNode slowNode = head.next;
    ListNode fastNode = head.next.next;
    while (fastNode != slowNode) {
      if (fastNode.next == null || fastNode.next.next == null) {
        return null;
      }
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    slowNode = head;
    while (slowNode != fastNode) {
      slowNode = slowNode.next;
      fastNode = fastNode.next;
    }
    return slowNode;
  }
}
