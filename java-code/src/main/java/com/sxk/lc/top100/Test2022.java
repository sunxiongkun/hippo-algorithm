package com.sxk.lc.top100;

import com.sxk.entity.ListNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxk
 */
public class Test2022 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 11)));
    System.out.println(lengthOfLongestSubstring("abcabbcdefg"));

    int[] result = merge(new int[]{1, 3, 5, 7}, new int[]{2, 4});
    System.out.println(Arrays.toString(result));

    System.out.println(findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4}));
  }

  /**
   * 两数之和： https://leetcode-cn.com/problems/two-sum/
   * <p>
   * time: O(N) space: O(N)
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diffNum = target - nums[i];
      if (map.containsKey(diffNum)) {
        return new int[]{i, map.get(diffNum)};
      }
      map.put(nums[i], i);
    }
    return result;
  }

  /**
   * 两数相加：https://leetcode-cn.com/problems/add-two-numbers/
   * <p>
   * time: O(M+N) space: O(M+N)
   *
   * @param l1
   * @param l2
   * @return
   */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode fakeNode = new ListNode();
    ListNode cur = fakeNode;
    ListNode p1 = l1;
    ListNode p2 = l2;
    int addNum = 0;
    while (p1 != null || p2 != null) {
      int num1 = p1 == null ? 0 : p1.val;
      int num2 = p2 == null ? 0 : p2.val;
      int sum = num1 + num2 + addNum;
      addNum = sum / 10;
      ListNode node = new ListNode();
      node.val = sum % 10;
      cur.next = node;
      cur = cur.next;
      p1 = p1 == null ? null : p1.next;
      p2 = p2 == null ? null : p2.next;
    }

    if (addNum > 0) {
      cur.next = new ListNode(addNum);
    }

    return fakeNode.next;
  }

  /**
   * 无重复字符的最长子串 :https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
   * <p>
   * time: O(N) space: O(N)
   *
   * @param s
   * @return
   */
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    char[] chars = s.toCharArray();
    int left = 0;
    int res = 0;
    for (int i = 0; i < chars.length; i++) {
      char curChar = chars[i];
      if (map.containsKey(curChar)) {
        left = Math.max(left, map.get(curChar) + 1);
      }
      res = Math.max(res, i - left + 1);
      map.put(curChar, i);
    }
    return res;
  }


  /**
   * 寻找两个正序数组的中位数:https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] arr = merge(nums1, nums2);
    int len = arr.length;
    if (len % 2 == 0) {
      return (arr[len / 2 - 1] + arr[len / 2]) / 2d;
    } else {
      return (double) arr[len / 2];
    }

  }

  private static int[] merge(int[] nums1, int[] nums2) {
    int len = Math.min(nums1.length, nums2.length);
    int[] result = new int[nums1.length + nums2.length];
    int i = 0, j = 0, k = 0;
    while (i < len && j < len) {
      result[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
    }
    while (j < nums2.length) {
      result[k++] = nums2[j++];
    }
    while (i < nums1.length) {
      result[k++] = nums1[i++];
    }
    return result;
  }

  /**
   * 最长回文子串：https://leetcode-cn.com/problems/longest-palindromic-substring/
   *
   * @param s
   * @return
   */
  public static String longestPalindrome(String s) {
    char[] array = s.toCharArray();
    int len = array.length;
    if (len == 1) {
      return s;
    }
    boolean[][] dp = new boolean[len][len];
    int begin = 0;
    int maxLen = 1;
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }


    return null;
  }


}
