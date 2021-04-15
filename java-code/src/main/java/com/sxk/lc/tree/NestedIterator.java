package com.sxk.lc.tree;

import java.util.Iterator;
import java.util.List;

/**
 * @author sxk
 * @date 2021/3/29 7:11 下午
 */
public class NestedIterator implements Iterator<Integer> {

  private static class NestedInteger {

    private Integer val;
    private List<NestedInteger> list;

    public boolean isInteger() {
      return val != null;
    }

    public Integer getInteger() {
      return val;
    }

    public List<NestedInteger> getList() {
      return list;
    }
  }

  public NestedIterator(List<NestedInteger> nestedList) {

  }

  @Override
  public Integer next() {
    return 1;
  }

  @Override
  public boolean hasNext() {
    return false;
  }
}
