package com.sxk.lc.exercise.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class Code36LinkCycle {


  /**
   * 141. 环形链表
   * https://leetcode-cn.com/problems/linked-list-cycle/
   *
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode fastNode = head.next.next;
    ListNode slowNode = head.next;
    while (fastNode != null && fastNode.next != null) {
      if (fastNode == slowNode) {
        return true;
      }
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    return false;
  }

  public ListNode intersectNode(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode fastNode = head.next.next;
    ListNode slowNode = head.next;
    while (fastNode != slowNode) {
      if (fastNode.next == null || fastNode.next.next == null) {
        return null;
      }
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    fastNode = head;
    while (fastNode != slowNode) {
      fastNode = fastNode.next;
      slowNode = slowNode.next;
    }
    return slowNode;
  }
}
