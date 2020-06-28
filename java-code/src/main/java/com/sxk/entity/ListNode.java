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
    return sb.toString().replaceFirst("->", "");
  }

  public static ListNode sequenceList(Integer capacity) {
    return sequenceList(0, capacity);
  }

  public static ListNode sequenceList(Integer start, Integer end) {
    ListNode head = new ListNode(Integer.MAX_VALUE);
    ListNode cur = head;
    for (int i = start; i < end; i++) {
      ListNode l1 = new ListNode(i);
      cur.next = l1;
      cur = l1;
    }
    return head.next;
  }
}
