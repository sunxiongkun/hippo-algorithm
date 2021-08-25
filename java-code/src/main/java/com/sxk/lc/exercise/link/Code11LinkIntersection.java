package com.sxk.lc.exercise.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class Code11LinkIntersection {

  public static void main(String[] args) {

  }

  /**
   * 160. 相交链表
   * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
   *
   * @param headA
   * @param headB
   * @return
   */

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    int len1 = length(headA);
    int len2 = length(headB);
    ListNode largestNode = len1 > len2 ? headA : headB;
    ListNode smallNode = largestNode.equals(headA) ? headB : headA;
    int diff = Math.abs(len1 - len2);
    ListNode fastNode = largestNode;
    ListNode slowNode = smallNode;
    for (int i = 0; i < diff; i++) {
      fastNode = fastNode.next;
    }
    while (fastNode != null && slowNode != null) {
      if (fastNode.equals(slowNode)) {
        return fastNode;
      }
      fastNode = fastNode.next;
      slowNode = slowNode.next;
    }
    return null;
  }

  public static int length(ListNode head) {
    int res = 0;
    ListNode cur = head;
    while (cur != null) {
      cur = cur.next;
      res++;
    }
    return res;
  }


}
