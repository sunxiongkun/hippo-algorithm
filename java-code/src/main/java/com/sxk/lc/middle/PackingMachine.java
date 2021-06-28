package com.sxk.lc.middle;

import java.util.Arrays;

/**
 * @author sxk
 */
public class PackingMachine {

  public static void main(String[] args) {
    int[] arr = {0, 0, 0, 100};
    System.out.println(optNum(arr));
  }

  /**
   * 机器人移动，洗衣机问题
   * @param array
   * @return
   */
  public static int optNum(int[] array) {

    int sum = Arrays.stream(array).sum();
    int length = array.length;
    if (sum % length != 0) {
      return -1;
    }
    int avg = sum / length;
    int leftSum = 0;
    int ans = 0;

    for (int i = 0; i < length; i++) {
      //负需要输入 正需要输出
      int leftRest = leftSum - i * avg;
      int rightRest = (sum - leftSum - array[i]) - (length - i - 1) * avg;
      if (leftRest < 0 && rightRest < 0) {
        int res = Math.abs(leftRest) + Math.abs(rightRest);
        ans = Math.max(ans, res);
      } else {
        int res = Math.max(Math.abs(leftRest), Math.abs(rightRest));
        ans = Math.max(ans, res);
      }
      leftSum += array[i];
    }
    return ans;

  }

}
