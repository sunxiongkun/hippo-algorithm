package com.sxk.lc.dp.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sxk
 * @date 2021/4/24 10:41 上午
 */
public class StringSubSequence {

  public static void main(String[] args) {
    System.out.println(subSequence("abc"));
  }

  /**
   * 全部子串 从左向右尝试，第一个位置到最后一个位置
   *
   * @param s
   * @return
   */
  private static List<String> subSequence(String s) {
    List<String> ans = new ArrayList<>();
    final char[] arr = s.toCharArray();
    process(arr, 0, "", ans);
    return ans;
  }

  /***
   * index 到达当前位置 要不要当前字符
   * 到达最后位置，放到ans中
   *
   * @param arr
   * @param index
   * @param path
   * @param ans
   */
  public static void process(char[] arr, int index, String path, List<String> ans) {
    if (index == arr.length) {
      ans.add(path);
      return;
    }
    process(arr, index + 1, path, ans);
    process(arr, index + 1, path + arr[index], ans);
  }

}
