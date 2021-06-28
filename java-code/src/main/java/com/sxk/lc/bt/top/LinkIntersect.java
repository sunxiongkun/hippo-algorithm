package com.sxk.lc.bt.top;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkIntersect {

  public static void main(String[] args) {
    ListNode intersectNode = new ListNode(4);
    ListNode headA = new ListNode();
    headA.next = new ListNode(1);
    headA.next.next = new ListNode(2);
    headA.next.next.next = new ListNode(3);
    headA.next.next.next.next = intersectNode;
    headA.next.next.next.next.next = new ListNode(5);
    headA.next.next.next.next.next.next = new ListNode(6);
    ListNode headB = new ListNode();
    headB.next = new ListNode(1);
    headB.next.next = new ListNode(2);
    headB.next.next.next = intersectNode;
    System.out.println(headA);
    System.out.println(headB);

    System.out.println(getIntersectionNode(headA, headB));

  }

  /**
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
    System.out.println(len1);
    System.out.println(len2);
    ListNode fakeNode1 = new ListNode();
    ListNode fakeNode2 = new ListNode();
    if (len1 > len2) {
      fakeNode1.next = headA;
      fakeNode2.next = headB;
    } else {
      fakeNode1.next = headB;
      fakeNode2.next = headA;
    }

    int diff = Math.abs(len1 - len2);
    int i = 0;
    while (fakeNode1.next != null && i++ < diff) {
      fakeNode1 = fakeNode1.next;
    }
    while (fakeNode1.next != null) {
      fakeNode1 = fakeNode1.next;
      fakeNode2 = fakeNode2.next;
      if (fakeNode1 == fakeNode2) {
        return fakeNode1;
      }
    }
    return null;
  }

  public static int length(ListNode head) {
    ListNode fakeNode = new ListNode();
    fakeNode.next = head;
    int ans = 0;
    while (fakeNode.next != null) {
      fakeNode = fakeNode.next;
      ans++;
    }
    return ans;
  }

}
