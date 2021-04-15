package com.sxk.entity;

import lombok.Data;

/**
 * @author sxk
 */
@Data
public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

}
