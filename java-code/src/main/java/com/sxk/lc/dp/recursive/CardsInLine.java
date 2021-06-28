package com.sxk.lc.dp.recursive;

/**
 * @author sxk
 * @date 2021/4/24 12:03 下午
 */
public class CardsInLine {


  /***
   * 纸牌博弈
   * 范围尝试模型
   *
   * @param arr
   * @return
   */
  public static int win(int[] arr) {
    final int first = first(arr, 0, arr.length - 1);
    final int second = second(arr, 0, arr.length - 1);
    return Math.max(first, second);
  }

  /**
   * 先选择牌的最大价值
   *
   * @param arr
   * @param left
   * @param right
   * @return
   */
  public static int first(int[] arr, int left, int right) {
    if (left == right) {
      return arr[left];
    }
    int selectLeftPrice = arr[left] + second(arr, left + 1, right);
    int selectRightPrice = arr[right] + second(arr, left, right - 1);
    return Math.max(selectLeftPrice, selectRightPrice);

  }

  /**
   * 后选择的最大价值
   *
   * @param arr
   * @param left
   * @param right
   * @return
   */
  public static int second(int[] arr, int left, int right) {
    if (left == right) {
      return 0;
    }
    //对手选择了arr[left]，自己只能在left+1...right找最大价值
    int selectLeftPrice = first(arr, left + 1, right);
    //对手选择了arr[right]，自己只能在left+1...right找最大价值
    int selectRightPrice = first(arr, left, right - 1);
    return Math.min(selectLeftPrice, selectRightPrice);
  }

}
