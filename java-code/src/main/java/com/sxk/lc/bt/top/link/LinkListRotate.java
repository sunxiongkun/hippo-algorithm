package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListRotate {

  public static void main(String[] args) {
    ListNode head = ListNode.sequenceList(1, 7);

    System.out.println(rotateRight(head, 6));
    //System.out.println(rotateRight(head, 2));
    //System.out.println(rotateRight(head, 8));
    //System.out.println(rotateRight(head, 1));
    System.out.println(rotateRight(head, 7));

  }


  /**
   * 旋转链表
   * 61 -> https://leetcode-cn.com/problems/rotate-list/
   *
   * @param head
   * @param k
   * @return
   */
  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    int length = length(head);
    int moveNum = k % length;
    if (moveNum == 0) {
      return head;
    }
    int rightNum = length - moveNum;

    ListNode cur = head;
    for (int i = 1; i < rightNum; i++) {
      cur = cur.next;
    }
    ListNode second = cur.next;
    cur.next = null;
    ListNode tail = second;
    while (tail.next != null) {
      tail = tail.next;
    }
    tail.next = head;
    return second;
  }

  public static int length(ListNode head) {
    int length = 0;
    ListNode cur = head;
    while (cur != null) {
      length++;
      cur = cur.next;
    }
    return length;
  }
}
