package com.sxk.lc;

import com.sxk.entity.ListNode;

public class TwoNumberAdd {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l12 = new ListNode(2);
    ListNode l13 = new ListNode(3);
    l1.setNext(l12);
    l12.setNext(l13);
    ListNode l2 = new ListNode(2);
    System.out.println(l1);
    System.out.println(addTwoNumbers(l1, l2));
  }


  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carry + x + y;
      if (sum < 10) {
        carry = 0;
      } else {
        carry = 1;
      }
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return dummyHead.next;
  }


}


