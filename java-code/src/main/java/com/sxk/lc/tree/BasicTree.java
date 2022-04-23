package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 前序遍历的递推公式： preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)
 * <p>
 * 中序遍历的递推公式： inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)
 * <p>
 * 后序遍历的递推公式： postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r
 *
 * @author sxk
 */

public class BasicTree {

  public static void main(String[] args) {
    TreeNode root = createFullBinaryTree();

    System.out.println("=============前序遍历===============");
    ArrayList<Integer> resultPreOrder = new ArrayList<>();
    preOrderTraversalRecursive(root, resultPreOrder);
    System.out.println("递归: " + resultPreOrder);

    System.out.println("分治: " + preOrderTraversalDivide(root));

    System.out.println("用栈: " + preOrderTraversal(root));

    System.out.println("=============中序遍历===============");
    ArrayList<Integer> resultInOrder = new ArrayList<>();
    inOrderTraversalRecursive(root, resultInOrder);
    System.out.println("递归: " + resultInOrder);

    System.out.println("分治: " + inOrderTraversalDivide(root));

    System.out.println("=============后序遍历===============");
    ArrayList<Integer> resultPostOrder = new ArrayList<>();
    postOrderTraversalRecursive(root, resultPostOrder);
    System.out.println("递归: " + resultPostOrder);

    System.out.println("分治: " + postOrderTraversalDivide(root));

  }

  /********************** // 深度 高度 层
   * *********0        // 0    2   3
   * ******11       12    // 1    1   2
   * ***21  22   23  24   // 2    0   1
   * return 满二叉树
   */
  public static TreeNode createFullBinaryTree() {
    TreeNode root = new TreeNode(0);
    TreeNode t11 = new TreeNode(11);
    TreeNode t12 = new TreeNode(12);

    TreeNode t21 = new TreeNode(21);
    TreeNode t22 = new TreeNode(22);
    TreeNode t23 = new TreeNode(23);
    TreeNode t24 = new TreeNode(24);

    root.setLeft(t11);
    root.setRight(t12);

    t11.setLeft(t21);
    t11.setRight(t22);

    t12.setLeft(t23);
    t12.setRight(t24);
    return root;
  }

  /********************** // 深度 高度 层
   * *********50        // 0    2   3
   * ******10      100    // 1    1   2
   * ***9  11   99    101   // 2    0   1
   * return 满二叉树
   */
  public static TreeNode createBinarySearchTree() {
    TreeNode root = new TreeNode(50);
    TreeNode t11 = new TreeNode(10);
    TreeNode t12 = new TreeNode(100);

    TreeNode t21 = new TreeNode(9);
    TreeNode t22 = new TreeNode(11);
    TreeNode t23 = new TreeNode(99);
    TreeNode t24 = new TreeNode(101);
    root.setLeft(t11);
    root.setRight(t12);

    t11.setLeft(t21);
    t11.setRight(t22);

    t12.setLeft(t23);
    t12.setRight(t24);
    return root;
  }

  /********************** // 深度 高度 层
   * *********0        // 0    3   4
   * ******11       12    // 1    2   3
   * ***21  22   23  24   // 2    1   2
   * 31   32              // 3    0   1
   * return 完全二叉树
   */
  public static TreeNode createLeftFullBinaryTree() {
    TreeNode root = new TreeNode(0);
    TreeNode t11 = new TreeNode(11);
    TreeNode t12 = new TreeNode(12);

    TreeNode t21 = new TreeNode(21);
    TreeNode t22 = new TreeNode(22);
    TreeNode t23 = new TreeNode(23);
    TreeNode t24 = new TreeNode(24);

    TreeNode t31 = new TreeNode(31);
    TreeNode t32 = new TreeNode(32);

    root.setLeft(t11);
    root.setRight(t12);

    t11.setLeft(t21);
    t11.setRight(t22);

    t12.setLeft(t23);
    t12.setRight(t24);

    t21.setLeft(t31);
    t21.setRight(t32);
    return root;
  }

  /*****************************前序遍历*********************************/

  // 借助栈
  public static ArrayList<Integer> preOrderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode current = stack.pop();
      result.add(current.val);
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
    }

    return result;
  }

  // 递归顺 每个节点都会到达3次
  //递归
  public static void preOrderTraversalRecursive(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }
    result.add(root.val);
    preOrderTraversalRecursive(root.left, result);
    preOrderTraversalRecursive(root.right, result);

  }

  //分治
  public static ArrayList<Integer> preOrderTraversalDivide(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<Integer> left = preOrderTraversalDivide(root.left);
    ArrayList<Integer> right = preOrderTraversalDivide(root.right);
    result.add(root.val);
    result.addAll(left);
    result.addAll(right);
    return result;
  }

  /*****************************中序遍历*********************************/


  public static void inOrderTraversalRecursive(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }
    inOrderTraversalRecursive(root.left, result);
    result.add(root.val);
    inOrderTraversalRecursive(root.right, result);
  }

  public static ArrayList<Integer> inOrderTraversalDivide(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<Integer> left = inOrderTraversalDivide(root.left);
    ArrayList<Integer> right = inOrderTraversalDivide(root.right);
    result.addAll(left);
    result.add(root.val);
    result.addAll(right);
    return result;
  }

  /*****************************后序遍历*********************************/

  public static void postOrderTraversalRecursive(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }
    postOrderTraversalRecursive(root.left, result);
    postOrderTraversalRecursive(root.right, result);
    result.add(root.val);
  }

  public static ArrayList<Integer> postOrderTraversalDivide(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<Integer> leftNode = postOrderTraversalDivide(root.left);
    ArrayList<Integer> rightNode = postOrderTraversalDivide(root.right);
    result.addAll(leftNode);
    result.addAll(rightNode);
    result.add(root.val);
    return result;
  }

}
