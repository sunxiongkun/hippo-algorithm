package com.sxk.lc.link;

import com.sxk.entity.ListNode;

/**
 * @author sxk
 * @date 2021/4/21 8:18 下午
 */
public class CycleList {

  public static void main(String[] args) {

  }


  /**
   * https://leetcode-cn.com/problems/linked-list-cycle/
   *
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast != slow) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }

  /**
   * https://leetcode-cn.com/problems/linked-list-cycle-ii/
   *
   * @param head
   * @return
   */
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head, fast = head;
    while (fast != null) {
      slow = slow.next;
      if (fast.next != null) {
        fast = fast.next.next;
      } else {
        return null;
      }
      if (fast == slow) {
        ListNode ptr = head;
        while (ptr != slow) {
          ptr = ptr.next;
          slow = slow.next;
        }
        return ptr;
      }
    }
    return null;
  }

}
