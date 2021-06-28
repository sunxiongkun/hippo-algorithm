package com.sxk.lc.backtrack;

import java.util.LinkedList;
import java.util.List;

/***
 * 解决⼀个回溯问题，实际上就是⼀个决 策树的遍历过程。
 * 你只需要思考 3 个问题：
 * 1、路径：也就是已经做出的选择。
 * 2、选择列表：也就是你当前可以做的选择。
 * 3、结束条件：也就是到达决策树底层，⽆法再做选择的条件。
 * @author sxk
 */
public class BackTrackDemo {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3};
    System.out.println(new BackTrackDemo().permute(nums));
  }

  List<List<Integer>> res = new LinkedList<>();

  /**
   * 主函数，输⼊⼀组不重复的数字，返回它们的全排列
   *
   * @param nums
   * @return
   */

  List<List<Integer>> permute(int[] nums) {
    // 记录「路径」
    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return res;
  }


  /***
   * 路径：记录在 track 中
   * // 选择列表：nums 中不存在于 track 的那些元素
   * // 结束条件：nums 中的元素全都在 track 中出现
   *
   * @param nums
   * @param track
   */
  void backtrack(int[] nums, LinkedList<Integer> track) {
    // 触发结束条件
    if (track.size() == nums.length) {
      res.add(new LinkedList<Integer>(track));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      // 排除不合法的选择
      if (track.contains(nums[i])) {
        continue;
      }
      // 做选择
      track.add(nums[i]);
      // 进⼊下⼀层决策树
      backtrack(nums, track);
      // 取消选择
      track.removeLast();
    }
  }
}
