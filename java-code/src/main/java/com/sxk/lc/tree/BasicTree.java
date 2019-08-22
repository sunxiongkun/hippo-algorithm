package com.sxk.lc.tree;

import com.sxk.entity.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 前序遍历的递推公式： preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)
 *
 * 中序遍历的递推公式： inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)
 *
 * 后序遍历的递推公式： postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r
 */

public class BasicTree {

  public static void main(String[] args) {
    TreeNode root = createTestTree();

    System.out.println("=============前序遍历===============");
    ArrayList<String> resultPreOrder = new ArrayList<String>();
    preOrderTraversalRecursive(root, resultPreOrder);
    System.out.println("递归: " + resultPreOrder);

    System.out.println("分治: " + preOrderTraversalDivide(root));

    System.out.println("用栈: " + preOrderTraversal(root));

    System.out.println("=============中序遍历===============");
    ArrayList<String> resultInOrder = new ArrayList<String>();
    inOrderTraversalRecursive(root, resultInOrder);
    System.out.println("递归: " + resultInOrder);

    System.out.println("分治: " + inOrderTraversalDivide(root));

    System.out.println("=============后序遍历===============");
    ArrayList<String> resultPostOrder = new ArrayList<String>();
    postOrderTraversalRecursive(root, resultPostOrder);
    System.out.println("递归: " + resultPostOrder);

    System.out.println("分治: " + postOrderTraversalDivide(root));

  }

  /********************** // 深度 高度 层
   * *********root        // 0    2   3
   * ******11       12    // 1    1   2
   * ***21  22   23  24   // 2    0   1
   * return
   */
  public static TreeNode createTestTree() {
    TreeNode root = new TreeNode("root");
    TreeNode t11 = new TreeNode("11");
    TreeNode t12 = new TreeNode("12");

    TreeNode t21 = new TreeNode("21");
    TreeNode t22 = new TreeNode("22");
    TreeNode t23 = new TreeNode("23");
    TreeNode t24 = new TreeNode("24");

    root.setLeftNode(t11);
    root.setRightNode(t12);

    t11.setLeftNode(t21);
    t11.setRightNode(t22);

    t12.setLeftNode(t23);
    t12.setRightNode(t24);
    return root;
  }

  /*****************************前序遍历*********************************/

  // 借助栈
  public static ArrayList<String> preOrderTraversal(TreeNode root) {
    ArrayList<String> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode current = stack.pop();
      result.add(current.self);
      if (current.rightNode != null) {
        stack.push(current.rightNode);
      }
      if (current.leftNode != null) {
        stack.push(current.leftNode);
      }
    }

    return result;
  }

  //递归
  public static void preOrderTraversalRecursive(TreeNode root, ArrayList<String> result) {
    if (root == null) {
      return;
    }
    result.add(root.self);
    preOrderTraversalRecursive(root.leftNode, result);
    preOrderTraversalRecursive(root.rightNode, result);

  }

  //分治
  public static ArrayList<String> preOrderTraversalDivide(TreeNode root) {
    // write your code here
    ArrayList<String> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<String> left = preOrderTraversalDivide(root.leftNode);
    ArrayList<String> right = preOrderTraversalDivide(root.rightNode);
    result.add(root.self);
    result.addAll(left);
    result.addAll(right);
    return result;
  }

  /*****************************中序遍历*********************************/


  public static void inOrderTraversalRecursive(TreeNode root, ArrayList<String> result) {
    if (root == null) {
      return;
    }
    inOrderTraversalRecursive(root.leftNode, result);
    result.add(root.self);
    inOrderTraversalRecursive(root.rightNode, result);
  }

  public static ArrayList<String> inOrderTraversalDivide(TreeNode root) {
    // write your code here
    ArrayList<String> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<String> left = inOrderTraversalDivide(root.leftNode);
    ArrayList<String> right = inOrderTraversalDivide(root.rightNode);
    result.addAll(left);
    result.add(root.self);
    result.addAll(right);
    return result;
  }

  /*****************************后序遍历*********************************/

  public static void postOrderTraversalRecursive(TreeNode root, ArrayList<String> result) {
    if (root == null) {
      return;
    }
    postOrderTraversalRecursive(root.leftNode, result);
    postOrderTraversalRecursive(root.rightNode, result);
    result.add(root.self);
  }

  public static ArrayList<String> postOrderTraversalDivide(TreeNode root) {
    ArrayList<String> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<String> leftNode = postOrderTraversalDivide(root.leftNode);
    ArrayList<String> rightNode = postOrderTraversalDivide(root.rightNode);
    result.addAll(leftNode);
    result.addAll(rightNode);
    result.add(root.self);
    return result;
  }

}
