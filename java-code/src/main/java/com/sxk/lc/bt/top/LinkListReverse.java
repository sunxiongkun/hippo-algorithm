package com.sxk.lc.bt.top;

import com.sxk.entity.ListNode;

/**
 * @author sxk https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */
public class LinkListReverse {

  public static void main(String[] args) {
    ListNode head = ListNode.sequenceList(1, 8);

    System.out.println(reverseKGroup(head, 2));

  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummyNode = new ListNode();
    dummyNode.next = head;
    ListNode pre = dummyNode;
    ListNode end = dummyNode;
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
    return dummyNode.next;


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
