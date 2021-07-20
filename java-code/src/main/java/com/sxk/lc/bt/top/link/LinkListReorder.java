package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 */
public class LinkListReorder {

  public static void main(String[] args) {
    ListNode head = ListNode.sequenceList(1, 4);
    System.out.println(head);
    reorderList(head);
    System.out.println(head);

  }

  /**
   * 重排链表
   * 143 -> https://leetcode-cn.com/problems/reorder-list/
   * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
   * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
   * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
   * 分成两部分，将后半部分反转，拼接
   * 链表奇升偶降 输入: 1->8->3->6->5->4->7->2->NULL 输出: 1->2->3->4->5->6->7->8->NULL
   * https://mp.weixin.qq.com/s?__biz=MzkxNDI1MTA1MA==&mid=2247484398&idx=1&sn=2734c206cea6db8bbf3bf01b8b4a334a&source=41#wechat_redirect
   *
   * @param head
   */

  public static void reorderList(ListNode head) {
    //middle or upMiddle
    ListNode middleNode = findMiddle(head);
    if (middleNode == null) {
      return;
    }
    ListNode middleNextNode = middleNode.next;
    middleNode.next = null;
    ListNode secondHead = reverse(middleNextNode);
    mergeTwoList(head, secondHead);
  }

  public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
    ListNode fakeNode = new ListNode();
    ListNode p1 = head1;
    ListNode p2 = head2;
    ListNode cur = fakeNode;
    int i = 0;
    while (p1 != null && p2 != null) {
      if (i++ % 2 == 0) {
        cur.next = p1;
        p1 = p1.next;
      } else {
        cur.next = p2;
        p2 = p2.next;
      }
      cur = cur.next;
    }
    if (p1 != null) {
      cur.next = p1;
    }
    if (p2 != null) {
      cur.next = p2;
    }
    return fakeNode.next;
  }

  public static ListNode findMiddle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode slowNode = head.next;
    ListNode fastNode = head.next.next;
    while (fastNode.next != null && fastNode.next.next != null) {
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    return slowNode;
  }


  public static ListNode reverse(ListNode head) {
    if (head == null) {
      return null;
    }
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
