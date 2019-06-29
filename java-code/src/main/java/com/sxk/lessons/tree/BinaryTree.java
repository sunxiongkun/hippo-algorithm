package com.sxk.lessons.tree;

import lombok.Data;

public class BinaryTree {

  public static void main(String[] args) {
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

    preOrder(root);
    System.out.println("===============");
    inOrder(root);
    System.out.println("===============");
    preOrder(root);


  }


  /**
   * 前序遍历的递推公式： preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)
   *
   * 中序遍历的递推公式： inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)
   *
   * 后序遍历的递推公式： postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r
   */

  public static void preOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.println(root.getSelf());
    preOrder(root.getLeftNode());
    preOrder(root.getRightNode());
  }

  public static void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.getLeftNode());
    System.out.println(root.getSelf());
    inOrder(root.getRightNode());
  }

  public static void postOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    postOrder(root.getLeftNode());
    postOrder(root.getRightNode());
    System.out.println(root.getSelf());
  }


}

@Data
class TreeNode {

  private String self;
  private TreeNode leftNode;
  private TreeNode rightNode;

  public TreeNode(String self) {
    this.self = self;
  }
}
