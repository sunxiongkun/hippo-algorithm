package com.sxk.lc.exercise.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sxk
 */
public class Code24NumDuplicateMerge {


  public static void main(String[] args) {
    int[][] intervals = {
        {1, 3},
        {2, 6},
        {8, 10},
        {15, 18}
    };
    int[][] result = merge(intervals);
    for (int i = 0; i < result.length; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
  }

  /**
   * 56. 合并区间
   * https://leetcode-cn.com/problems/merge-intervals/
   *
   * @param intervals
   * @return
   */
  public static int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
      return new int[0][2];
    }
    List<int[]> res = new ArrayList<>();
    Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);

    res.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int l = intervals[i][0];
      int r = intervals[i][1];
      int lastArray = res.size() - 1;
      int marRightVal = res.get(lastArray)[1];
      if (marRightVal < l) {
        res.add(new int[]{l, r});
      } else {
        res.get(lastArray)[1] = Math.max(r, marRightVal);
      }
    }
    return res.toArray(new int[res.size()][]);
  }


}
