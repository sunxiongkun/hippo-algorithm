package com.sxk.lc.top100;

import com.sxk.entity.ListNode;
import com.sxk.entity.TreeNode;
import com.sxk.lc.tree.BasicTree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringJoiner;
import lombok.Data;

/**
 * @author sxk
 */
public class TreeTest implements Serializable {

  public static void main(String[] args) {

    final ListNode head = ListNode.sequenceList(5);
    System.out.println(head);
    final ListNode head1 = reverseList(head);
    System.out.println(head1);

    final TreeNode root = BasicTree.createFullBinaryTree();
    final List<List<TreeNode>> r1 = level(root);
    System.out.println(r1);
    final List<List<TreeNode>> r2 = zigZag(root);
    System.out.println(r2);

  }

  public static List<List<TreeNode>> level(TreeNode root) {
    final List<List<TreeNode>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      final List<TreeNode> curLevelList = new ArrayList<>();
      result.add(curLevelList);
      final int size = queue.size();
      for (int i = 0; i < size; i++) {
        final TreeNode curNode = queue.poll();
        curLevelList.add(curNode);
        final TreeNode left = curNode.left;
        final TreeNode right = curNode.right;
        if (left != null) {
          queue.offer(left);
        }
        if (right != null) {
          queue.offer(right);
        }
      }
    }
    return result;
  }


  public static List<List<TreeNode>> zigZag(TreeNode root) {
    final List<List<TreeNode>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> cur = new Stack<>();
    Stack<TreeNode> next = new Stack<>();
    Stack<TreeNode> temp;
    cur.push(root);
    boolean isLevel = true;

    while (!cur.isEmpty()) {
      final List<TreeNode> curLevelList = new ArrayList<>();
      result.add(curLevelList);
      int size = cur.size();
      for (int i = 0; i < size; i++) {
        TreeNode curNode = cur.pop();
        curLevelList.add(curNode);
        final TreeNode left = curNode.left;
        final TreeNode right = curNode.right;
        if (isLevel) {
          if (left != null) {
            next.push(left);
          }
          if (right != null) {
            next.push(right);
          }
        } else {
          if (right != null) {
            next.push(right);
          }
          if (left != null) {
            next.push(left);
          }
        }
      }
      temp = cur;
      cur = next;
      next = temp;
      isLevel = !isLevel;
    }

    return result;
  }


  public static ListNode reverseList(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }


  static int preVal = Integer.MIN_VALUE;

  public static boolean isBst(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!isBst(root.left)) {
      return false;
    }
    if (root.val <= preVal) {
      return false;
    }
    preVal = root.val;
    return isBst(root.right);
  }

  public static boolean isSame(TreeNode root) {
    if (root == null) {
      return false;
    }
    return isSame(root.left, root.right);
  }

  public static boolean isSame(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left != null && right != null) {
      if (left.val != right.val) {
        return false;
      }
      final boolean leftSame = isSame(left.left, right.right);
      final boolean rightSame = isSame(left.right, right.left);
      return leftSame && rightSame;
    }
    return false;
  }

  public static int getMaxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int leftDepth = getMaxDepth(root.left);
    final int rightDepth = getMaxDepth(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
  }

  static Map<Integer, Integer> inMap = new HashMap<>();

  public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
    int n = preOrder.length;
    for (int i = 0; i < n; i++) {
      inMap.put(inOrder[i], i);
    }
    return buildTree(preOrder, inOrder, 0, n - 1, 0, n - 1);
  }

  public static TreeNode buildTree(int[] preOrder, int[] inOrder, int preLeft,
      int preRight, int inLeft, int inRight) {
    if (preLeft > preRight) {
      return null;
    }
    final int rootVal = preOrder[preLeft];
    final TreeNode root = new TreeNode(rootVal);
    int inOrderRoot = inMap.get(rootVal);
    int leftSubTreeSize = inOrderRoot - inLeft;
    root.left = buildTree(preOrder, inOrder, preLeft + 1, preLeft + leftSubTreeSize, inLeft,
        inOrderRoot - 1);
    root.right = buildTree(preOrder, inOrder, preLeft + leftSubTreeSize + 1, preRight,
        inOrderRoot + 1,
        inRight);
    return root;
  }


  public static TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  public static TreeNode sortedArrayToBST(int[] nums, int leftIndex, int rightIndex) {
    if (leftIndex > rightIndex) {
      return null;
    }
    final int middleIndex = (rightIndex - leftIndex) / 2;
    final TreeNode root = new TreeNode(nums[middleIndex]);
    root.left = sortedArrayToBST(nums, leftIndex, middleIndex);
    root.right = sortedArrayToBST(nums, middleIndex - 1, rightIndex);
    return root;
  }


  @Data
  private static class Node {

    int val;
    Node left;
    Node right;
    Node next;
  }

  /**
   * 完美二叉树
   *
   * @param root
   * @return
   */
  public static Node connect(Node root) {
    if (root == null) {
      return null;
    }
    connect(root.left, root.right);
    return root;
  }

  public static void connect(Node node1, Node node2) {
    if (node1.left == null) {
      return;
    }
    node1.next = node2;
    connect(node1.left, node2.right);
    connect(node2.left, node2.right);
    connect(node1.right, node2.left);
  }


  public static int maxPathSum(TreeNode root) {
    return maxPathSum1(root).distance;
  }

  public static PathInfo maxPathSum1(TreeNode root) {
    if (root == null) {
      return new PathInfo(0, 0);
    }
    final PathInfo leftInfo = maxPathSum1(root.left);
    final PathInfo rightInfo = maxPathSum1(root.right);
    int height = Math.max(leftInfo.height, rightInfo.height) + 1;
    int distance = Math.max(Math.max(leftInfo.distance, rightInfo.distance),
        (leftInfo.distance + rightInfo.distance) + 1);

    return new PathInfo(height, distance);
  }

  @Data
  private static class PathInfo {

    private int height;
    private int distance;

    PathInfo(int height, int distance) {
      this.height = height;
      this.distance = distance;
    }
  }

  static int rank = 0;

  public static int kthSmallest(TreeNode root, int k) {
    if (root == null) {
      return 0;
    }
    kthSmallest(root.left, k);
    if (k == rank) {
      return root.val;
    }
    rank++;
    kthSmallest(root.right, k);
    return 0;
  }

  public static TreeNode commonParent(TreeNode root, TreeNode p, TreeNode q) {
    final HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
    parentMap.put(root, null);
    nodeParent(root, parentMap);
    TreeNode cur = p;
    final HashSet<TreeNode> set = new HashSet<>();
    set.add(cur);
    while (parentMap.get(cur) != null) {
      cur = parentMap.get(cur);
      set.add(cur);
    }
    cur = q;
    while (!set.contains(cur)) {
      cur = parentMap.get(cur);
    }
    return cur;
  }

  public static void nodeParent(TreeNode root, HashMap<TreeNode, TreeNode> parentMap) {
    final TreeNode left = root.left;
    if (left != null) {
      parentMap.put(left, root);
      nodeParent(left, parentMap);
    }
    final TreeNode right = root.right;
    if (left != null) {
      parentMap.put(right, root);
      nodeParent(right, parentMap);
    }
  }

  static String split = ",";
  static String nullStr = "#";


  public static String serialize(TreeNode root) {
    final StringJoiner sj = new StringJoiner(split);
    serialize(root, sj);
    return sj.toString();
  }

  public static void serialize(TreeNode root, StringJoiner sj) {
    if (root == null) {
      sj.add(nullStr);
      return;
    }
    sj.add(String.valueOf(root.val));
    serialize(root.left, sj);
    serialize(root.right, sj);
  }

  public static TreeNode deSerialize(String str) {
    return null;
  }

  public static TreeNode deSerialize(Queue<String> list) {
    final String poll = list.poll();
    if (nullStr.equals(poll)) {
      return null;
    }
    final TreeNode root = new TreeNode(Integer.valueOf(poll));
    root.left = deSerialize(list);
    root.right = deSerialize(list);
    return root;

  }

}
