package com.sxk.lc.link;

import com.sxk.entity.ListNode;

public class LinkListOperation {

  public static void main(String[] args) {
    ListNode simpleList = ListNode.sequenceList(7);
    System.out.println(simpleList.toString());

    System.out.println("list middle:" + findMiddle(simpleList));

    simpleList = reverseList(simpleList);
    System.out.println("reverse list:" + simpleList);

    removeNthFromEnd(simpleList, 3);
    System.out.println("remove 3 from end:" + simpleList);

    ListNode l1 = ListNode.sequenceList(1, 4);
    ListNode l2 = ListNode.sequenceList(2, 5);

    //System.out.println(mergeTwoLists(l1, l2));

    ListNode twoSortLists = mergeTwoSortLists(l1, l2);
    System.out.println("merge two sort lists:" + twoSortLists);

    ListNode noDuplicationList = deleteAllDuplication(twoSortLists);
    System.out.println("no duplication list:" + noDuplicationList);

    ListNode[] lists = new ListNode[]{ListNode.sequenceList(4), ListNode.sequenceList(4),
        ListNode.sequenceList(5)};
    System.out.println("merge k list:" + mergeKLists(lists));

  }

  /**
   * 返回它的中间元素
   */
  public static Integer findMiddle(ListNode head) {
    ListNode first = head;
    ListNode second = head;
    while (first != null && first.next != null) {
      first = first.next.next;
      second = second.next;
    }
    return second.val;
  }

  /**
   * 链表反转
   */
  public static ListNode reverseList(ListNode head) {
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


  /**
   * 倒数第n个元素
   * 快慢指针
   */
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


  /**
   * 有序链表删除所有重复的元素
   */
  public static ListNode deleteAllDuplication(ListNode head) {
    if (head == null) {
      return null;
    }
    //prev 会变化，提前记录
    ListNode dummyNode = new ListNode(-1);
    dummyNode.next = head;
    ListNode pre = dummyNode;
    ListNode cur = head;

    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        int num = cur.val;
        while (cur != null && cur.val == num) {
          cur = cur.next;
        }
        pre.next = cur;
      } else {
        pre = cur;
        cur = cur.next;
      }
    }

    return dummyNode.next;
  }

  public static ListNode deleteDuplication(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode curr = head;
    while (curr.next != null) {
      if (curr.val == curr.next.val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }
    return head;
  }


}
