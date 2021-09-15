package com.sxk.lc.exercise.num;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sxk
 */
public class Code51CombinationSum {

  public static void main(String[] args) {

  }

  /**
   * 39. 组合总和
   * https://leetcode-cn.com/problems/combination-sum/
   *
   * @param candidates
   * @param target
   * @return
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();
    dfs(candidates, target, ans, combine, 0);
    return ans;
  }

  public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine,
      int idx) {
    if (idx == candidates.length) {
      return;
    }
    if (target == 0) {
      ans.add(new ArrayList<>(combine));
      return;
    }
    // 直接跳过
    dfs(candidates, target, ans, combine, idx + 1);
    // 选择当前数
    if (target - candidates[idx] >= 0) {
      combine.add(candidates[idx]);
      // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
      dfs(candidates, target - candidates[idx], ans, combine, idx);
      combine.remove(combine.size() - 1);
    }
  }

}
