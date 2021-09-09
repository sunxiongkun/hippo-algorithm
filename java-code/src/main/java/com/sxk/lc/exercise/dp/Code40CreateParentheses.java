package com.sxk.lc.exercise.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sxk
 */
public class Code40CreateParentheses {


  public static void main(String[] args) {

  }

  /**
   * 22. 括号生成
   * https://leetcode-cn.com/problems/generate-parentheses/
   *
   * @param n
   * @return
   */
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    generateAll(new char[2 * n], 0, res);
    return res;
  }

  public void generateAll(char[] arr, int point, List<String> res) {
    if (point == arr.length) {
      if (valid(arr)) {
        res.add(new String(arr));
      }
    } else {
      arr[point] = '(';
      generateAll(arr, point + 1, res);
      arr[point] = ')';
      generateAll(arr, point + 1, res);
    }
  }

  public boolean valid(char[] arr) {
    int count = 0;
    for (char c : arr) {
      if (c == '(') {
        count++;
      } else {
        count--;
      }
      if (count < 0) {
        return false;
      }
    }
    return count == 0;
  }


}
