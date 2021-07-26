package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;
import java.util.HashMap;
import lombok.Data;

/**
 * @author sxk
 */
public class LinkListKthFromEnd {

  public static void main(String[] args) {

    ListNode head = ListNode.sequenceList(1, 6);
    System.out.println(head);
    System.out.println(getKthFromEnd(head, 2));
  }

  /**
   * 剑指 Offer 22. 链表中倒数第k个节点
   * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
   *
   * @param head
   * @param k
   * @return
   */
  public static ListNode getKthFromEnd(ListNode head, int k) {
    ListNode fast = head;
    ListNode slow = head;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  /**
   * 删除链表的倒数第 N 个结点
   * 19 -> https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
   *
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fakeNode = new ListNode();
    fakeNode.next = head;
    ListNode fastNode = fakeNode;
    ListNode slowNode = fakeNode;
    for (int i = 0; i <= n; i++) {
      fastNode = fastNode.next;
    }
    while (fastNode != null) {
      fastNode = fastNode.next;
      slowNode = slowNode.next;
    }
    slowNode.next = slowNode.next.next;
    return fakeNode.next;
  }


  /**
   * 两两交互节点
   * 24 -> https://leetcode-cn.com/problems/swap-nodes-in-pairs/
   *
   * @param head
   * @return
   */
  public static ListNode swapPairs(ListNode head) {
    ListNode fakeNode = new ListNode();
    fakeNode.next = head;
    ListNode cur = fakeNode;

    while (cur.next != null && cur.next.next != null) {
      ListNode next1 = cur.next;
      ListNode next2 = cur.next.next;
      cur.next = next2;
      next1.next = next2.next;
      next2.next = next1;
      cur = next1;
    }

    return fakeNode.next;
  }

  @Data
  static class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  /**
   * 复制带随机指针的链表
   * 138->https://leetcode-cn.com/problems/copy-list-with-random-pointer/
   *
   * @param head
   * @return
   */
  public static Node copyRandomList(Node head) {
    HashMap<Node, Node> map = new HashMap<>();
    Node cur = head;
    while (cur != null) {
      map.put(cur, new Node(cur.val));
      cur = cur.next;
    }
    cur = head;
    while (cur != null) {
      map.get(cur).next = map.get(cur.next);
      map.get(cur).random = map.get(cur.random);
      cur = cur.next;
    }
    return map.get(head);
  }
}
