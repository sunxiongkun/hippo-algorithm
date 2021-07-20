package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */
public class LinkListReverse {

  public static void main(String[] args) {
    ListNode head = ListNode.sequenceList(1, 8);

    System.out.println(reverseKGroup(head, 2));

    head = ListNode.sequenceList(1, 8);

    System.out.println(reverseBetween(head, 3, 5));

  }

  /**
   * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
   *
   * @param head
   * @param k
   * @return
   */
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

  /**
   * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
   *
   * @param head
   * @return
   */
  public static ListNode swapPairs(ListNode head) {
    ListNode dummyHead = new ListNode();
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

  /**
   * 反转链表ii
   * 92-> https://leetcode-cn.com/problems/reverse-linked-list-ii/
   * 1 <= left <= right <= n
   *
   * @param head
   * @param left
   * @param right
   * @return
   */
  public static ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || head.next == null || left == right) {
      return head;
    }
    // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
    ListNode dummyNode = new ListNode();
    dummyNode.next = head;

    ListNode pre = dummyNode;
    // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
    // 建议写在 for 循环里，语义清晰
    for (int i = 0; i < left - 1; i++) {
      pre = pre.next;
    }

    // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
    ListNode rightNode = pre;
    for (int i = 0; i < right - left + 1; i++) {
      rightNode = rightNode.next;
    }

    // 第 3 步：切断出一个子链表（截取链表）
    ListNode leftNode = pre.next;
    ListNode curr = rightNode.next;

    // 注意：切断链接
    pre.next = null;
    rightNode.next = null;

    reverse(leftNode);

    // 第 5 步：接回到原来的链表中
    pre.next = rightNode;
    leftNode.next = curr;
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
