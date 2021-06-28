package com.sxk.lc.middle;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sxk
 */
public class TowArrayMove {

  public static void main(String[] args) {
    int[] arr1 = {1, 3, 4, 6, 7, 8, 10};
    int[] arr2 = {2, 5, 7, 8, 20, 30, 50, 60};
    System.out.println(process(arr1, arr2));
  }

  /**
   * 只能平均值大的数组向平均值小的数组移动
   *
   * @param arr1
   * @param arr2
   * @return
   */
  public static int process(int[] arr1, int[] arr2) {
    double sum1 = (double) Arrays.stream(arr1).sum();
    double sum2 = (double) Arrays.stream(arr2).sum();
    if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
      return 0;
    }
    int[] arrMore;
    int[] arrLess;
    double sumMore;
    double sumLess;

    /**
     * 只能平均值大的数组向平均值小的数组移动
     * 比如arr1 的平均值100  arr2的平均值50
     * 只能在arr1中找50< ? <100 且最左边的移动，才能保证arr1的平均值升的更高，arr2的平均值升的最少
     * 这样下次平均值的范围更大，移动的次数更多
     */
    if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
      arrMore = arr1;
      sumMore = sum1;
      arrLess = arr2;
      sumLess = sum2;
    } else {
      arrMore = arr2;
      sumMore = sum2;
      arrLess = arr1;
      sumLess = sum1;
    }
    //O(N*logN)
    Arrays.sort(arrMore);

    final Set<Integer> setLess = Arrays.stream(arrLess)
        .boxed()
        .collect(Collectors.toSet());
    int moreSize = arrMore.length;
    int lessSize = arrLess.length;
    int ans = 0;
    //O(N)
    for (int i = 0; i < moreSize; i++) {
      double cur = arrMore[i];
      if (cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize)
          && !setLess.contains(arrMore[i])) {
        moreSize--;
        sumMore -= cur;
        lessSize++;
        sumLess += cur;
        setLess.add(arrMore[i]);
        ans++;
      }

    }
    return ans;
  }

  public static double avg(double sum, int size) {
    return sum / size;
  }

}
