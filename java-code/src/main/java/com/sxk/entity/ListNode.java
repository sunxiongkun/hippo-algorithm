package com.sxk.entity;

import lombok.Data;

@Data
public class ListNode {

  public Integer val;
  public ListNode next;

  public ListNode(Integer val) {
    this.val = val;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    ListNode currentNode = this;
    while (currentNode != null) {
      sb.append("->").append(currentNode.val);
      currentNode = currentNode.next;

    }
    return sb.toString();
  }

  public static ListNode sequenceList(Integer capacity) {
    ListNode head = new ListNode(Integer.MAX_VALUE);
    ListNode cur = head;
    for (int i = 0; i < capacity; i++) {
      ListNode l1 = new ListNode(i);
      cur.next = l1;
      cur = l1;
    }

    return head.next;
  }
}
