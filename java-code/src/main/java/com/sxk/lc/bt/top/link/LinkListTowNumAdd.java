package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListTowNumAdd {


  public static void main(String[] args) {

  }

  /**
   * 两数相加
   * 2-> https://leetcode-cn.com/problems/add-two-numbers/
   *
   * @param l1
   * @param l2
   * @return
   */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode fakeNode = new ListNode();
    ListNode cur = fakeNode;
    ListNode p1 = l1;
    ListNode p2 = l2;
    int carry = 0;
    while (p1 != null || p2 != null) {
      int num1 = p1 != null ? p1.val : 0;
      int num2 = p2 != null ? p2.val : 0;
      int sum = num1 + num2 + carry;
      carry = sum >= 10 ? 1 : 0;
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
      p1 = p1 != null ? p1.next : null;
      p2 = p2 != null ? p2.next : null;
    }
    if (carry > 0) {
      cur.next = new ListNode(carry);
    }
    return fakeNode.next;
  }
}
