package com.sxk.lc.top100;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkFindMiddle {

  public static void main(String[] args) {
    ListNode head = ListNode.sequenceList(4);
    System.out.println(head);
    System.out.println(midOrUpMidNode(head).val);
    System.out.println(midOrDownMidNode(head).val);

  }

  // head 头
  public static ListNode midOrUpMidNode(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    // 链表有3个点或以上
    ListNode slow = head.next;
    ListNode fast = head.next.next;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static ListNode midOrDownMidNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head.next;
    ListNode fast = head.next;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static ListNode midOrUpMidPreNode(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head.next.next;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static ListNode midOrDownMidPreNode(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    if (head.next.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
