package com.sxk.entity;

import lombok.Data;

@Data
public class TreeNode {

  public String self;
  public TreeNode leftNode;
  public TreeNode rightNode;

  public TreeNode(String self) {
    this.self = self;
  }
}
