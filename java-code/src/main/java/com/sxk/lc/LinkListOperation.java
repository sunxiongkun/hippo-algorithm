package com.sxk.lc;

import com.sxk.entity.ListNode;

public class LinkListOperation {

  public static void main(String[] args) {
    ListNode simpleList = ListNode.sequenceList(8);
    System.out.println(simpleList.toString());

    removeNthFromEnd(simpleList, 2);
    System.out.println(simpleList.toString());

    ListNode l1 = ListNode.sequenceList(4);
    ListNode l2 = ListNode.sequenceList(8);

    //System.out.println(mergeTwoLists(l1, l2));

    System.out.println(mergeTwoSortLists(l1, l2));

    ListNode[] lists = new ListNode[]{ListNode.sequenceList(4), ListNode.sequenceList(4),
        ListNode.sequenceList(5)};
    System.out.println(mergeKLists(lists));

  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
      first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;

  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummyNode = new ListNode(Integer.MAX_VALUE);

    ListNode cur1 = l1, cur2 = l2;

    ListNode temp = dummyNode;

    while (cur1 != null && cur2 != null) {
      ListNode next1 = cur1.next;
      ListNode next2 = cur2.next;

      temp.next = cur1;
      cur1.next = cur2;

      temp = cur2;

      cur1 = next1;
      cur2 = next2;
      if (next1 == null) {
        temp = next2;
        break;
      }
      if (next2 == null) {
        temp = next1;
        break;
      }

    }

    return dummyNode.next;
  }


  public static ListNode mergeTwoSortLists(ListNode l1, ListNode l2) {
    // maintain an unchanging reference to node ahead of the return node.
    ListNode prehead = new ListNode(-1);

    ListNode prev = prehead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }

    // exactly one of l1 and l2 can be non-null at this point, so connect
    // the non-null list to the end of the merged list.
    prev.next = l1 == null ? l2 : l1;

    return prehead.next;

  }

  public static ListNode mergeKLists(ListNode[] lists) {

    ListNode temp = lists[0];
    for (int i = 1; i < lists.length; i++) {
      temp = mergeTwoSortLists(temp, lists[i]);
    }
    return temp;
  }


}
