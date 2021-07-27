package com.sxk.lc.bt.top.link;

import com.sxk.entity.ListNode;
import com.sxk.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sxk
 */
public class LinkListToBst {

  public static void main(String[] args) {
    ListNode head = ListNode.sequenceList(1, 6);
    System.out.println(head);
    System.out.println(sortedListToBST(head));
  }

  /**
   * 有序链表转换为二叉搜索数
   * 109 -> https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
   *
   * @param head
   * @return
   */
  public static TreeNode sortedListToBST(ListNode head) {
    List<Integer> list = new ArrayList<>();
    ListNode cur = head;
    while (cur != null) {
      list.add(cur.val);
      cur = cur.next;
    }
    Integer[] array = list.toArray(new Integer[]{});
    return process(array, 0, array.length - 1);
  }

  public static TreeNode process(Integer[] nums, int l, int r) {
    if (l > r) {
      return null;
    }
    int middle = l + (r - l) / 2;
    TreeNode root = new TreeNode(nums[middle]);
    root.left = process(nums, l, middle - 1);
    root.right = process(nums, middle + 1, r);
    return root;
  }


}
