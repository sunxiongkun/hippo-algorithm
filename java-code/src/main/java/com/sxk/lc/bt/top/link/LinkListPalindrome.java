package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListPalindrome {

  public static void main(String[] args) {

    ListNode head = ListNode.sequenceList(1, 5);
    System.out.println(head);
    System.out.println(isPalindrome(head));


  }

  /**
   * 判断是否是回文链表
   * 234 -> https://leetcode-cn.com/problems/palindrome-linked-list/
   *
   * @param head
   * @return
   */
  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode middle = findMiddle(head);
    ListNode next = middle.next;
    middle.next = null;
    ListNode newNext = reverse(next);
    boolean isPalindrome = isPalindrome(head, newNext);
    middle.next = reverse(newNext);
    return isPalindrome;
  }


  public static ListNode findMiddle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode slow = head.next;
    ListNode fast = head.next.next;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
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

  public static boolean isPalindrome(ListNode head1, ListNode head2) {
    ListNode p1 = head1;
    ListNode p2 = head2;
    while (p1 != null && p2 != null) {
      if (p1.val != p2.val) {
        return false;
      }
      p1 = p1.next;
      p2 = p2.next;
    }
    return true;
  }
}
