package com.sxk.lc.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 * @date 2021/4/5 6:56 下午
 */
public class ListReverse {

  public static void main(String[] args) {
    final ListNode head = ListNode.sequenceList(5);
    System.out.println(head);
    System.out.println(new ListReverse().swapPairs(head));
  }

  /**
   * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;
    ListNode end = dummy;

    while (end.next != null) {
      for (int i = 0; i < k && end != null; i++) {
        end = end.next;
      }
      if (end == null) {
        break;
      }
      ListNode start = pre.next;
      ListNode next = end.next;
      end.next = null;
      pre.next = reverse(start);
      start.next = next;
      pre = start;
      end = pre;
    }
    return dummy.next;
  }

  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    return prev;
  }

  public ListNode swapPairs1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = head.next;
    head.next = swapPairs1(newHead.next);
    newHead.next = head;
    return newHead;
  }

  /**
   * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
   *
   * @param head
   * @return
   */
  public ListNode swapPairs(ListNode head) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode temp = dummyHead;
    while (temp.next != null && temp.next.next != null) {
      ListNode node1 = temp.next;
      ListNode node2 = temp.next.next;
      temp.next = node2;
      node1.next = node2.next;
      node2.next = node1;
      temp = node1;
    }
    return dummyHead.next;
  }

}
